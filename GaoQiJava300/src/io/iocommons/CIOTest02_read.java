package io.iocommons;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * 读取内容
 * @author yang
 *
 */
public class CIOTest02_read {
	public static void main(String[] args) throws IOException {
		//读取文件
		String msg = FileUtils.readFileToString(new File("xx.txt"),"UTF-8");
		System.out.println(msg);
		System.out.println(msg.length());//11
		byte[] msg2 = FileUtils.readFileToByteArray(new File("xx.txt"));
		System.out.println("---------------");
		System.out.println(msg2);//数组对象，直接打印是内存地址
		System.out.println(msg2.length);//11 d
		//逐行读取
		System.out.println("---------------");
		List<String> msgs3 = FileUtils.readLines(new File("xx.txt"),"UTF-8");
		for (String string : msgs3) {//逐行读取到容器中
			System.out.println(string);
		}
		//迭代器逐行读取
		System.out.println("---------------");
		LineIterator it = FileUtils.lineIterator(new File("xx.txt"),"UTF-8");
		while(it.hasNext()){
			System.out.println(it.nextLine());
		}
	}
}
