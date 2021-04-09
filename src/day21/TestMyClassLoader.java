package day21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//�������
class MyClassLoader extends ClassLoader{
	private String pathName;
	public MyClassLoader(String pathName) {
		this.pathName = pathName;//������pathName��������ֵΪ d:/data/
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = null;
		// ����nameΪ :  Hello��Ҫ��pathNameƴ�ӳ�   d:/data/Hello.class,Ȼ������������
		String path = pathName + name + ".class";
		File f = new File(path);
		FileInputStream fin = null;
		try {
			
			fin = new FileInputStream(f);
			byte [] b = new byte[fin.available()];
			int len = fin.read(b);//ͨ�������ֽ����ļ�������ݶ����ֽ�����b��,���ض������ֽ���
			//defineClass()�������ֽ�����ת��Ϊ��class��ʵ������ʹ�ø���֮ǰ������Ը�����н�����
			//Ҳ����˵defineClass()������byte����������ݽ����ɷ������ܹ�ʶ������ݽṹ,Ҳ���ǰ�
			//�ֽ����ļ��ŵ��˷�����,�����ڶ������ɶ���ģ��			
			c = this.defineClass(name, b, 0, len); 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		} finally {
			if(fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		
		return c;
	}
	
}
public class TestMyClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		//�Լ�ָ������ ��·��
		MyClassLoader loader = new MyClassLoader("d:/data/");
		/*
		 * forName(String name, boolean initialize,ClassLoader loader)������
		 * ʹ�ø����������������������������ӿڹ�����Class����ģ�塣
		 * ����name��Ҫ����ȫ�޶���, ��Ϊ���Զ��������, "Hello"��Ҳû��ʲô��, ����ֱ��д��
		 * initialize��ʾ�Ƿ���Ҫ�����ʼ��,true��ʾ��Ҫ��
		 * loaderָ��ʹ�õ����������
		 */
		Class.forName("Hello", true, loader); 

	}

}
