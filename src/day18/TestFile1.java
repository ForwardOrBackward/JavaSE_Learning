package day18;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class TestFile1 {

	public static void main(String[] args) throws IOException {
		// �ļ�
//		File f = new File("d:\\data\\a.txt");
//		File f = new File("d:/data/a.txt");
//		File f = new File("a.txt");
//		File f = new File("d:/data","a.txt");
		File file = new File("d:/data");
		File f = new File(file,"a.txt");
		//�ж� �ļ� �� Ŀ¼�Ƿ���ڣ����� true
		System.out.println(f.exists());//false
		//�½��ļ�
		f.createNewFile();
		System.out.println(f.exists());
		//�ļ���
		System.out.println(f.getName());
		//���·�� ������·�������·����
		System.out.println(f.getPath());
		//��õ��� ����·��
		System.out.println(f.getAbsolutePath());
		//����� ��·��
		System.out.println(f.getParent());
		//�ļ��Ƿ�� �� ��
		System.out.println(f.canRead());
		//�ļ��Ƿ� �����޸�
		System.out.println(f.canWrite());
		//�Ƿ� ���ļ�����true
		System.out.println(f.isFile());
		//����޸ĵ�ʱ��  ����
		System.out.println(f.lastModified());//long
//		Date date = new Date(1546999738141L);
//		System.out.println(date);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		System.out.println(df.format(f.lastModified()));
		//���� �ļ����ݵ��ֽ���  long 
		System.out.println(f.length());
		//
		f.delete();
		System.out.println(f.exists());
	}

}
