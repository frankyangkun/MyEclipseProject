package net;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

import net.N07_Employee;

/**
 * 引用类型
 * 发送端
 * @author yang
 * 1、使用DatagramSocket 指定端口，创建发送端
 * 2、将基本类型转成字节数组
 * 3、封装成DatagramPacket包裹，需要指定目的地
 * 4、发送包裹send(DatagramPacket p)  只管发
 * 5、释放资源
 */
public class N07_UdpObjectClient {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中...");
		//1、使用DatagramSocket 指定端口，创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		//2、准备数据 一定要转成字节数组
//		String data = "测试数据";
		//写出
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
		N07_Employee emp = new N07_Employee("frank",400);//自定义类实现了Serializable接口，也能序列化
		oos.writeObject(emp);
		oos.flush();
		fileoos.close();//因为异常抛了，所以手动关一下
		byte[] datas = baos.toByteArray();//去内存获取数据
		
//		System.out.println(datas.length);//15个字节
//		byte [] datas = data.getBytes();//转成字节数组，就不指定字符集了，默认utf8
		
		//3、封装成DatagramPacket包裹，需要指定目的地（这里就用本机，端口不要和发送端一样）
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
				new InetSocketAddress("127.0.0.1",9999));//不要写成localhost，否则收不到
		//4、发送包裹send(DatagramPacket p)  只管发
		client.send(packet);
		//5、释放资源
		client.close();
	}
}
