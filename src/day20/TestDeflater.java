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
		int length = in.remaining(); // ���ظû������л�ʣ��δ����Ԫ����
		// setInput()����Ҫѹ�����������ݡ�
		// ByteBuffer.arrayOffset()���ػ����������������д洢�Ŀ�ʼλ�õ�ƫ������һ���Ǵ�����ͷ 0
		// ��ʼ���㣩,�����з�(slice()����)����һ�������ṩ�洢�Ļ�����,����˶�����顣
		// ByteBuffer.position()���ص�����һ��Ҫ������д��Ԫ�ص�������λ�û��Զ�����Ӧ�� get() �� put() �������¡�
		// ������Ҫע�����positon��λ���Ǵ�0��ʼ��,Ҳ����˵, �����ƫ����?
		deflater.setInput(in.array(), in.arrayOffset() + in.position(), length);
		// ������finish()ʱ����ʾѹ��Ӧ�������뻺���������еĵ�ǰ���ݽ���,���ټ������������ݡ�
		deflater.finish();
		int outSize = 0;
		int offset = out.arrayOffset() + out.position();
		while (!deflater.finished() && (length > outSize)) {
			// Deflater.deflate() ѹ����������(setInput()��ָ����in�������е�����),
			// ����ѹ��������䵽ָ���Ļ�����(out������)������ʵ���Ѿ�ѹ���˶���in�е��ֽڡ�
			int size = deflater.deflate(out.array(), offset, out.remaining());
			out.position(size + out.position()); // position(int a)��ʾ�ѵ�ǰposition��Ϊa
			outSize += size;
			offset += size;
			// if we run out of space in the out buffer, use the overflow
			// ���out����������Ŀռ�������, �Ϳ�ʼʹ��overflow��
			if (out.remaining() == 0) {
				if (overflow == null) {
					// end() �ر�ѹ�����������κ�δ��������롣
					deflater.end();
					return false;
				}
				// ��overflow != nullʱ
				out = overflow;
				offset = out.arrayOffset() + out.position();
			}
		}
		deflater.end();
		return length > outSize;
	}

}
