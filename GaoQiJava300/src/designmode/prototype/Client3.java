package designmode.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 反序列化实现深复制
 * @author yang
 */
public class Client3 {
	public static void main(String[] args) throws Exception {
		Date d = new Date(12345123L);
		Sheep s1 = new Sheep("frank",d);
		System.out.println(s1);
		System.out.println(s1.getSname()+s1.getBirthday()+"老时间");
		
//		Sheep s2 = (Sheep) s1.clone();
		//这里用Sheep类，没有实现深克隆的类，我们用反序列化来实现深复制
		//注意：Sheep类要增加一个Serializable接口的实现
		//序列化，用FileOutpuStream也行
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);//因为要读的是Sheep对象，所以用对象流
		oos.writeObject(s1);
		byte[] bytes = bos.toByteArray();//把读到的数据转成字节数组，这样字节数组bytes里就包含了s1里的数据，包括s1属性的值也拷贝过来了
		
		//反序列化，用对象输入流
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Sheep s2 = (Sheep) ois.readObject();//克隆好的对象！
		
		
		d.setTime(1111333333L);//修改时间
		System.out.println(s1.getSname()+s1.getBirthday()+"新时间");
		
		System.out.println(s2);
		System.out.println(s2.getSname()+s2.getBirthday()+"克隆时间");//还是老时间，证明通过反序列化实现了深复制
		
		//也可修改原型的值
		s2.setSname("Tony");
		System.out.println(s2.getSname()+s2.getBirthday());
	}
}
