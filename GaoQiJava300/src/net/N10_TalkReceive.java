package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端：使用面向对象封装
 * @author yang
 *
 */
public class N10_TalkReceive implements Runnable{
	//1、使用DatagramSocket 指定端口，创建接收端
	DatagramSocket server; 
	private String from;//谁来接收
	public N10_TalkReceive(int port,String from){
		this.from = from;
		try {
			server = new DatagramSocket(port);//端口不能和发送端冲突
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		//2、准备容器 封装成DatagramPacket包裹
		while(true){//多次接收，每次准备不同的容器
			byte[] container = new byte[1024*60];//不要超过60k
			DatagramPacket packet = new DatagramPacket(container,0,container.length);//封装容器操作的还是字节数组
			//3、阻塞式接收包裹receive(DatagramPacket p)
			try {
				server.receive(packet);
				//4、分析数据 byte[] getData() getLength()
				byte[] datas = packet.getData();
				int len = packet.getLength();//或datas.length
				String data = new String(datas,0,len);
				System.out.println(from+":"+data);//还原
				if(data.equals("bye")){
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//5、释放资源
		server.close();
	}
}