package net;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

import net.N07_Employee;
/**
 * 引用类型
 * 接收端
 * Address already in use (Bind failed) 同一个协议下端口不能冲突
 * 1、使用DatagramSocket 指定端口，创建接收端
 * 2、准备容器 封装成DatagramPacket包裹
 * 3、阻塞式接收包裹receive(DatagramPacket p)
 * 4、分析数据 将字节数组还原为对应的类型
 * byte[] getData() getLength()
 * 5、释放资源
 * @author yang
 */
public class N07_UdpObjectServer {
	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中...");
		//1、使用DatagramSocket 指定端口，创建接收端
		DatagramSocket server = new DatagramSocket(9999);//端口不能和发送端冲突
		//2、准备容器 封装成DatagramPacket包裹
		byte[] container = new byte[1024*60];//不要超过60k
		DatagramPacket packet = new DatagramPacket(container,0,container.length);//封装容器操作的还是字节数组
		//3、阻塞式接收包裹receive(DatagramPacket p)
		server.receive(packet);
		//4、分析数据 byte[] getData() getLength() 将字节数组还原为对应的类型
		byte[] datas = packet.getData();
		int len = packet.getLength();//或datas.length
//		System.out.println(new String(datas,0,len));//还原
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
		if(employee instanceof N07_Employee){
			N07_Employee empObj = (N07_Employee)employee;
			System.out.println(empObj.getName()+"-->"+empObj.getSalary());
		} 
		//5、释放资源
		server.close();
	}
}
