package net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 * 多次交流
 * 接收端
 * Address already in use (Bind failed) 同一个协议下端口不能冲突
 * 1、使用DatagramSocket 指定端口，创建接收端
 * 2、准备容器 封装成DatagramPacket包裹
 * 3、阻塞式接收包裹receive(DatagramPacket p)
 * 4、分析数据
 * byte[] getData()
 *        getLength()
 * 5、释放资源
 * @author yang
 */
public class N09_UdpTalkServer {
	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中...");
		//1、使用DatagramSocket 指定端口，创建接收端
		DatagramSocket server = new DatagramSocket(6666);//端口不能和发送端冲突
		//2、准备容器 封装成DatagramPacket包裹
		while(true){//多次接收，每次准备不同的容器
			byte[] container = new byte[1024*60];//不要超过60k
			DatagramPacket packet = new DatagramPacket(container,0,container.length);//封装容器操作的还是字节数组
			//3、阻塞式接收包裹receive(DatagramPacket p)
			server.receive(packet);
			//4、分析数据 byte[] getData() getLength()
			byte[] datas = packet.getData();
			int len = packet.getLength();//或datas.length
			String data = new String(datas,0,len);
			System.out.println(data);//还原
			if(data.equals("bye")){
				break;
			}
		}
		//5、释放资源
		server.close();
	}
}
