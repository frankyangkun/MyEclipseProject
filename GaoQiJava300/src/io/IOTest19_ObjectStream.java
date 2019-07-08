package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 对象流测试（和data流大同小异）
 * 1、写出后再读取
 * 2、读取的顺序与写出保持一致
 * 3、不是所有对象都能序列化，必须实现Serializable接口
 * ObjectOutputStream
 * ObjectInputStream
 * @author yang
 */
public class IOTest19_ObjectStream {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//写出 注意ByteArrayOutputStream有新方法toByteArray，所以不能多态，必须单独写一行，并且不用释放
//		DataOutputStream dos = new DataOutputStream(new ByteArrayOutputStream());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//写出到字节数组，用于读取测试，有内容才能读取，也可以写到文件
		
		//序列化到字节数组
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));//加上缓冲流，提升性能
		//序列化到文件（存储到硬盘了，很久以后再还原或网络传输出去都没问题）
		ObjectOutputStream fileoos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.ser")));
		//操作数据类型+数据，任何数据都可转成字节数组
		oos.writeUTF("测试");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		//对象（对象流的新增方法）-->序列化
		oos.writeObject("字符串对象");//字符串也是对象，String实现了Serializable接口，因此可以序列化
		oos.writeObject(new Date());//Date也是实现了Serializable接口，因此可以序列化
		Employee emp = new Employee("frank",400);//自定义类实现了Serializable接口，也能序列化
		oos.writeObject(emp);
		oos.flush();
		fileoos.close();//因为异常抛了，所以手动关一下
		byte[] datas = baos.toByteArray();//去内存获取数据
		System.out.println(datas.length);//15个字节
		//读取-->反序列化
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		ObjectInputStream fileois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")));
		//顺序与写出一致下面每一行顺序不能换，要和上面一致，否则报错
		String msg = ois.readUTF();
		int age = ois.readInt();
		boolean flag = ois.readBoolean();
		char ch = ois.readChar();
		System.out.println(flag);
		//对象的数据还原
		Object str = ois.readObject();//新加的3个对象，顺序不能变
		Object date = ois.readObject();
		Object employee = ois.readObject();
		//对象还原时需要判断一下，然后强转一下
		if(str instanceof String){
			String strObj = (String)str;
			System.out.println(strObj);
		} 
		if(date instanceof Date){
			Date dateObj = (Date)date;
			System.out.println(dateObj);
		} 
		if(employee instanceof Employee){
			Employee empObj = (Employee)employee;
			System.out.println(empObj.getName()+"-->"+empObj.getSalary());
		} 
		fileois.close();
	}
}
//javabean
class Employee implements Serializable{
	private String name;
	private transient double salary;//transient代表该数据不需要序列化
	public Employee() {
	}
	public Employee(String name,double salary) {
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}