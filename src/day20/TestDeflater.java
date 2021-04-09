package day20;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;

public class TestDeflater {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte[] bt = new byte[10];
		ByteBuffer in = ByteBuffer.allocate(50);
		ByteBuffer out = ByteBuffer.allocate(50);
		ByteBuffer overflow = ByteBuffer.allocate(5);
		TestDeflater test = new TestDeflater();
		test.compress(in,out,overflow);
		
	}

	public boolean compress(ByteBuffer in, ByteBuffer out, ByteBuffer overflow) throws IOException {
		Deflater deflater = new Deflater(9, true);
		deflater.setStrategy(1);
		int length = in.remaining(); // 返回该缓冲区中还剩余未读的元素数
		// setInput()设置要压缩的输入数据。
		// ByteBuffer.arrayOffset()返回缓冲区数据在数组中存储的开始位置的偏移量（一般是从数组头 0
		// 开始计算）,除非切分(slice()方法)了由一个数组提供存储的缓冲区,变成了多个数组。
		// ByteBuffer.position()返回的是下一个要被读或写的元素的索引。位置会自动由相应的 get() 和 put() 函数更新。
		// 这里需要注意的是positon的位置是从0开始的,也就是说, 是相对偏移量?
		deflater.setInput(in.array(), in.arrayOffset() + in.position(), length);
		// 当调用finish()时，表示压缩应该以输入缓冲区中已有的当前内容结束,不再加入新输入数据。
		deflater.finish();
		int outSize = 0;
		int offset = out.arrayOffset() + out.position();
		while (!deflater.finished() && (length > outSize)) {
			// Deflater.deflate() 压缩输入数据(setInput()中指定的in缓冲区中的数据),
			// 并用压缩数据填充到指定的缓冲区(out缓冲区)。返回实际已经压缩了多少in中的字节。
			int size = deflater.deflate(out.array(), offset, out.remaining());
			out.position(size + out.position()); // position(int a)表示把当前position设为a
			outSize += size;
			offset += size;
			// if we run out of space in the out buffer, use the overflow
			// 如果out缓冲区里面的空间用完了, 就开始使用overflow了
			if (out.remaining() == 0) {
				if (overflow == null) {
					// end() 关闭压缩器并丢弃任何未处理的输入。
					deflater.end();
					return false;
				}
				// 当overflow != null时
				out = overflow;
				offset = out.arrayOffset() + out.position();
			}
		}
		deflater.end();
		return length > outSize;
	}

}
