package net;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 基本类型
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
public class N06_UdpTypeServer {
	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中...");
		//1、使用DatagramSocket 指定端口，创建接收端
		DatagramSocket server = new DatagramSocket(6666);//端口不能和发送端冲突
		//2、准备容器 封装成DatagramPacket包裹
		byte[] container = new byte[1024*60];//不要超过60k
		DatagramPacket packet = new DatagramPacket(container,0,container.length);//封装容器操作的还是字节数组
		//3、阻塞式接收包裹receive(DatagramPacket p)
		server.receive(packet);
		//4、分析数据 byte[] getData() getLength() 将字节数组还原为对应的类型
		byte[] datas = packet.getData();
		int len = packet.getLength();//或datas.length
//		System.out.println(new String(datas,0,len));//还原
		
		//读取
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new 
				ByteArrayInputStream(datas)));
		//顺序与写出一致下面每一行顺序不能换，要和上面一致，否则报错
		String msg = dis.readUTF();
		int age = dis.readInt();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		System.out.println(msg+"-->"+flag);
		//5、释放资源
		server.close();
	}
}
