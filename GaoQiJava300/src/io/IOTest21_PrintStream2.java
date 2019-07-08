package io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
/**
 * 打印流PrintWriter
 * @author yang
 */
public class IOTest21_PrintStream2 {
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("PrintWriter.txt")),true);//true代表自动刷新
		pw.println("打印流");
		pw.println(true);
		pw.close();
	}
}
