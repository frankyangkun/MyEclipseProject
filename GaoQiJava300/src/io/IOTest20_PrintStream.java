package io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
/**
 * 打印流PrintStream（打印一些内容到文件中）
 * @author yang
 *
 */
public class IOTest20_PrintStream {
	
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = System.out;
		ps.println("打印流");
		ps.println(true);
		
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("PrintStream.txt")),true);//true代表自动刷新
		ps.println("打印流");
		ps.println(true);
		
		//重定向输出端，这个输出端是一个打印流，重定向到文件中
		System.setOut(ps);//System.out默认输出到控制台
		System.out.println("change");//不再打印到控制台而是文件
		ps.close();//关闭要在操作之后
		
		//重定向回控制台(FileDescriptor.out 标准输出端)
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("back");
	}
}
