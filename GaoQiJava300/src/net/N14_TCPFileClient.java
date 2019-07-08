package net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 上传文件
 * 创建客户端，步骤如下：
 * 1、建立连接，使用Socket创建客户端+服务端的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 * @author yang
 */
public class N14_TCPFileClient {
	public static void main(String[] args) throws IOException {
		System.out.println("---------Client----------");
		 //1、建立连接，使用Socket创建客户端+服务端的地址和端口
		Socket client = new Socket("127.0.0.1",8888);
		 //2、操作：输入输出流操作 建议使用DataOutputStream
//		DataOutputStream dos = new DataOutputStream(client.getOutputStream());//输出流
//		String data = "hello";
//		dos.writeUTF(data);
//		dos.flush();
		//2、操作：拷贝文件 上传 文件大小没限制
		InputStream is = new BufferedInputStream(new FileInputStream("src/logo.png"));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		byte[] flush = new byte[1024];
		int len = -1;
		while((len=is.read(flush))!=-1){
			os.write(flush,0,len);
		}
		os.flush();
		 //3、释放资源
		os.close();
		is.close();
		client.close();
	}
}
