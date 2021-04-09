package day18;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class TestFile2 {

	public static void main(String[] args) {
		// 目录
		File f = new File("D:\\浏览器下载");
//		System.out.println(f.exists());
		//是否是目录，是true
//		System.out.println(f.isDirectory());
		//获得 目录下的 子目录和文件的文件名称的数组
		String [] strs = f.list();
		//文件名过滤器
		strs = f.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.contains("1");
			}
		});
		//strs = f.list((d,name)-> name.endsWith("zip"));
		Arrays.stream(strs).forEach(System.out::println);
		//
		System.out.println("--------------------------");
		//获得 目录下的 子目录和文件的    File的数组
		File [] fs = f.listFiles();
		fs = f.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().contains("1");
			}
		});
		//fs = f.listFiles(fe -> fe.getName().endsWith("jpg"));
		Arrays.stream(fs).forEach(e->System.out.println(e.getName()));
		//---------------------------------------------
	}

}
