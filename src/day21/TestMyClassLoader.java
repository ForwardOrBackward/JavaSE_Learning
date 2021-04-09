package day21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//类加载器
class MyClassLoader extends ClassLoader{
	private String pathName;
	public MyClassLoader(String pathName) {
		this.pathName = pathName;//构造器pathName传进来的值为 d:/data/
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = null;
		// 参数name为 :  Hello。要和pathName拼接成   d:/data/Hello.class,然后用来创建流
		String path = pathName + name + ".class";
		File f = new File(path);
		FileInputStream fin = null;
		try {
			
			fin = new FileInputStream(f);
			byte [] b = new byte[fin.available()];
			int len = fin.read(b);//通过流将字节码文件里的内容读到字节数组b中,返回读到的字节数
			//defineClass()方法将字节数组转换为类class的实例。在使用该类之前，必须对该类进行解析。
			//也就是说defineClass()方法把byte数组里的数据解析成方法区能够识别的数据结构,也就是把
			//字节码文件放到了方法区,并且在堆中生成对象模板			
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
		//自己指定加载 的路径
		MyClassLoader loader = new MyClassLoader("d:/data/");
		/*
		 * forName(String name, boolean initialize,ClassLoader loader)方法是
		 * 使用给定的类加载器，返回与给定的类或接口关联的Class对象模板。
		 * 其中name需要用完全限定名, 因为是自定义加载器, "Hello"类也没有什么包, 可以直接写。
		 * initialize表示是否需要将类初始化,true表示需要。
		 * loader指定使用的类加载器。
		 */
		Class.forName("Hello", true, loader); 

	}

}
