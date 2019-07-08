package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流：InputStreamReader（字节流->字符流），OutputStreamWriter
 * 1、以字符流的形式操作字节流（纯文本）；
 * @author yang
 *
 */
public class IOTest16_ConvertTest {

	public static void main(String[] args) {
		//操作system.in,system.out，都是纯文本，所以可以进行转换
		try(
//		InputStreamReader isr = new InputStreamReader(System.in);//因为传过来的都是字符串，所以加缓冲，如下行
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//字节流已经由InputStreamReader转成字符流，因此可以加字符缓冲流
//		OutputStreamWriter osw = new OutputStreamWriter(System.out);//同理加缓冲，如下行
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));){
			//循环获取键盘输入，exit退出，并且输出
			String msg = "";
			while(!msg.equals("exit")){
				msg = reader.readLine();//循环逐行读取
				writer.write(msg);//循环逐行写出，以前是System.out.print输出
				writer.newLine();
				writer.flush();//强制刷新，不然输入的内容太少，没占满缓冲不会写出
			}
		}catch(IOException e){
			System.out.println("操作异常。");
		}//因为用了try-with-resource，就不释放了
	}
}
//所以虽然是通过键盘System.in和System.out，是字节，但是却以字符流的形式来操作