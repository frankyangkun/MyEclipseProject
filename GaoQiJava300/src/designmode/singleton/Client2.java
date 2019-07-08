package designmode.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 测试反射和反序列化破解单例模式
 * @author yang
 */
public class Client2 {
	public static void main(String[] args) throws Exception {
		Singleton6 s1 =Singleton6.getInstance();//构造器私有，不能new，只能通过方法获取对象
		Singleton6 s2 =Singleton6.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		
		//通过反射调用
//		Class<Singleton6> clazz = (Class<Singleton6>) Class.forName("designmode.Singleton6");
//		Constructor<Singleton6> c = clazz.getDeclaredConstructor(null);//获得无参构造器
//		
//		c.setAccessible(true);//跳过权限检查，允许访问私有
//		Singleton6 s3 = c.newInstance();
//		Singleton6 s4 = c.newInstance();
//		
//		System.out.println(s3);//因为是私有构造器，所以会报错，必须c.setAccessible(true);跳过权限检查
//		System.out.println(s4);
		
		//通过反序列化的方式构造多个对象
		//序列化（写到磁盘上）
		FileOutputStream fos = new FileOutputStream("/Users/yang/Downloads/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);//把s1写到a.txt
		oos.close();//非严密写法，不写try catch了，因为直接抛出了
		fos.close();
		
		//反序列化（从磁盘读出来）
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/yang/Downloads/a.txt"));
		Singleton6 s3 = (Singleton6) ois.readObject();
		System.out.println(s3);//结果和s1 s2不同，说明通过反序列化生成了新的对象
		
	}
}
