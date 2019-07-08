package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录，双向（即服务器告诉客户端登录是否成功）多客户端请求
 * 创建服务器，步骤如下：
 * 1、指定端口，使用ServerSocket创建服务器
 * 2、阻塞式等待连接accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 * @author yang
 */
public class N15_TCPLoginMultiServer {
	public static void main(String[] args) throws IOException {
		System.out.println("---------Server----------");
		 //1、指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		boolean isRunning = true;
		 //2、阻塞式等待连接accept
		//多客户端，加入while，并将while体封装多线程
		while(isRunning){//不要直接写成while(true)，否则server对象无法close，因为是死循环无法执行while外面的代码
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			new Thread(new Channel(client)).start();
		}
		server.close();//一般不会关闭服务，除非维护  不要放到while里
	}
	//建一个内部类，将while体的内容放进来，加入多线程，以便实现多用户并行操作，一个Channel代表一个客户端
	static class Channel implements Runnable{
		private Socket client;
		private DataInputStream dis;//输入流
		private DataOutputStream dos;	//输出流
		public Channel(Socket client){
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());//输入
				dos = new DataOutputStream(client.getOutputStream());//输出，也放到try里
			} catch (IOException e) {
				e.printStackTrace();
//				try {
//					client.close();
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}//如果出异常了，client就关闭
				release();
			}
		}
		//接收数据
		private String receive(){
			String datas = "";
			try {
				datas = dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}//加try，因为加while之前这部分在main里面，是throws了的
			return datas;
		}
		//释放资源
		private void release(){
			try {
				if(null!=dos){
					dos.close();//一般都要加上非空判断，或者使用try-with-resource
				}
				if(null!=dis){
					dis.close();
				}
				if(null!=client){
					client.close();//可以写到一个try里面
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//发送数据
		private void send(String msg){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
//			Socket client = server.accept();//这一步就放到while里去，当来了连接后启动多线程大家各自服务
//			System.out.println("一个客户端建立了连接");
			 //3、操作：输入输出流操作
//			DataInputStream dis;//没必要放在run里面，提出去，因为每个线程都需要执行输入输出流，所以try放到构造器初始化，无非就是输入输出流
//			try {
//				dis = new DataInputStream(client.getInputStream());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}//输入流 client需要在构造器中初始化，加try，因为加while之前这部分在main里面，是throws了的
//			String datas = dis.readUTF();//接收数据，新写个方法receive，专门用于返回数据
			String uname = "";
			String upwd = "";
			//分析
//			String[] dataArray = datas.split("&");//datas就变成了receive()返回的
			String[] dataArray = receive().split("&");
			for (String info : dataArray) {
				String[] userInfo = info.split("=");
				if(userInfo[0].equals("uname")){
					System.out.println("你的用户名为："+userInfo[1]);
					uname = userInfo[1];//别忘了这步
				}else if(userInfo[0].equals("upwd")){
					System.out.println("你的密码为："+userInfo[1]);
					upwd = userInfo[1];//别忘了这步
				}
			}
			//输出登录结果到客户端
//			DataOutputStream dos = new DataOutputStream(client.getOutputStream());//输出流，同理放到构造器,同理需要try
			if(uname.equals("shsxt") && upwd.equals("laopei")) {//后期需查数据库
//				dos.writeUTF("登录成功。");//封装成send方法
				send("登录成功。");
			}else{
//				dos.writeUTF("用户名或密码错误");
				send("用户名或密码错误");
			}
//			dos.flush();
			 //4、释放资源
//			dis.close();//封装成释放资源方法
//			client.close();
			release();
		}
	}
}
