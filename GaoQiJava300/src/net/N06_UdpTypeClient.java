package net;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 基本类型
 * 发送端
 * @author yang
 * 1、使用DatagramSocket 指定端口，创建发送端
 * 2、将基本类型转成字节数组
 * 3、封装成DatagramPacket包裹，需要指定目的地
 * 4、发送包裹send(DatagramPacket p)  只管发
 * 5、释放资源
 */
public class N06_UdpTypeClient {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中...");
		//1、使用DatagramSocket 指定端口，创建发送端
		DatagramSocket client = new DatagramSocket(9999);
		//2、准备数据 一定要转成字节数组
//		String data = "测试数据";
		//写出
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//写出到字节数组，用于读取测试，有内容才能读取，也可以写到文件
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));//加上缓冲流，提升性能
		//操作数据类型+数据，任何数据都可转成字节数组
		dos.writeUTF("测试");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas = baos.toByteArray();//去内存获取数据
//		System.out.println(datas.length);//15个字节
//		byte [] datas = data.getBytes();//转成字节数组，就不指定字符集了，默认utf8
		
		//3、封装成DatagramPacket包裹，需要指定目的地（这里就用本机，端口不要和发送端一样）
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
				new InetSocketAddress("127.0.0.1",6666));//不要写成localhost，否则收不到
		//4、发送包裹send(DatagramPacket p)  只管发
		client.send(packet);
		//5、释放资源
		client.close();
	}
}
