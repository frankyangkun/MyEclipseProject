package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * 多次交流
 * 发送端
 * @author yang
 * 1、使用DatagramSocket 指定端口，创建发送端
 * 2、准备数据 一定要转成字节数组
 * 3、封装成DatagramPacket包裹，需要指定目的地
 * 4、发送包裹send(DatagramPacket p)  只管发
 * 5、释放资源
 */
public class N09_UdpTalkClient {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中...");
		//1、使用DatagramSocket 指定端口，创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		//2、准备数据 一定要转成字节数组
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
	//		String data = "测试数据";
			String data = reader.readLine();
			byte [] datas = data.getBytes();//转成字节数组，就不指定字符集了，默认utf8
			//3、封装成DatagramPacket包裹，需要指定目的地（这里就用本机，端口不要和发送端一样）
			DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
					new InetSocketAddress("127.0.0.1",6666));//不要写成localhost，否则收不到
			//4、发送包裹send(DatagramPacket p)  只管发
			client.send(packet);
			if(data.equals("bye")){
				break;
			}
		}
		//5、释放资源
		client.close();
	}
}