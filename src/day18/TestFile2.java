package day18;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class TestFile2 {

	public static void main(String[] args) {
		// Ŀ¼
		File f = new File("D:\\���������");
//		System.out.println(f.exists());
		//�Ƿ���Ŀ¼����true
//		System.out.println(f.isDirectory());
		//��� Ŀ¼�µ� ��Ŀ¼���ļ����ļ����Ƶ�����
		String [] strs = f.list();
		//�ļ���������
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
		//��� Ŀ¼�µ� ��Ŀ¼���ļ���    File������
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
