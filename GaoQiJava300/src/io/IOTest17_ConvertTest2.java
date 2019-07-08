package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 转换输入流：InputStreamReader（字节流->字符流），OutputStreamWriter
 * 2、指定字符集
 * @author yang
 *
 */
public class IOTest17_ConvertTest2 {
	public static void main(String[] args) {
		//操作网络流 下载百度源代码 为了处理方便和效率，加上缓冲流
		try(BufferedReader reader = new BufferedReader (new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8"));//网络流，也是字节流
			BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(new FileOutputStream("baidu.html"),"UTF-8"));){//最好指定字符集
			//3、操作(读取) 逐行读取
			String msg;
			while((msg=reader.readLine())!=null){//文件末尾才是-1，否则返回的是字节代码
//				System.out.print(msg);
				writer.write(msg);
				writer.newLine();
			}
			writer.flush();
		}catch(IOException e){
			System.out.println("操作异常。");
		}//因为用了try-with-resource，就不释放了
	}
	public static void test02(){
	//操作网络流 下载百度源代码 加上转换流，将字节转换为字符（为了解决中文乱码问题）
	try(InputStreamReader is = new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8");){//网络流，也是字节流
		//3、操作(读取)
		int temp;
		while((temp=is.read())!=-1){//文件末尾才是-1，否则返回的是字节代码
			System.out.print((char)temp);
		}
	}catch(IOException e){
		System.out.println("操作异常。");
	}//因为用了try-with-resource，就不释放了
	}
	public static void test01() {
		//操作网络流 下载百度源代码
		try(InputStream is = new URL("http://www.baidu.com").openStream();){//网络流，也是字节流
			//3、操作(读取)
			int temp;
			while((temp=is.read())!=-1){//文件末尾才是-1，否则返回的是字节代码
				System.out.print((char)temp);//字节数不够出现乱码
			}
		}catch(IOException e){
			System.out.println("操作异常。");
		}//因为用了try-with-resource，就不释放了
	}
}
//所以虽然是通过键盘System.in和System.out，是字节，但是却以字符流的形式来操作