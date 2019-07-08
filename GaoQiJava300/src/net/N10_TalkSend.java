package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端：使用面向对象封装
 * @author yang
 */
public class N10_TalkSend implements Runnable{
	private DatagramSocket client;//1、使用DatagramSocket 指定端口，创建发送端
	private BufferedReader reader;//2、准备数据 一定要转成字节数组
	private String toIP;//对方的ip
	private int toPort;//对方的端口
	
	public N10_TalkSend(int port,String toIP,int toPort){
		this.toIP = toIP;
		this.toPort = toPort;
		try {
			client = new DatagramSocket(port);
		    reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(true){
	//		String data = "测试数据";
			String data;
			try {
				data = reader.readLine();//这里就不能throws了，要try
				byte [] datas = data.getBytes();//转成字节数组，就不指定字符集了，默认utf8
				//3、封装成DatagramPacket包裹，需要指定目的地（这里就用本机，端口不要和发送端一样）
				DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIP,this.toPort));//不要写成localhost，否则收不到
				//4、发送包裹send(DatagramPacket p)  只管发
				client.send(packet);
				if(data.equals("bye")){
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//5、释放资源
		client.close();
	}
}