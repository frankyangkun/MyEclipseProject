package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1、封装拷贝； 
 * 2、封装释放资源
 * @author yang
 */
public class FileUtils {

	/**
	 * 对接输入输出流
	 * @param is
	 * @param os
	 */
	public static void copy(InputStream is, OutputStream os) {
		try {
			// 3、操作(分段读取)
			byte[] flush = new byte[1024 * 10];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				// 字节数组-->字符串（解码）
				os.write(flush, 0, len);// 写出到字节数组中
			}
			os.flush();// 就不去释放baos了
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4、释放资源
			close(is,os);
		}
	}
	/**
	 * 释放资源（关闭输入输出流）
	 * @param is
	 * @param os
	 */
	public static void close(InputStream is, OutputStream os){
		try {
			if (os != null) {
				os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 释放资源（可关闭多个流）
	 * @param ios
	 */
	public static void close(Closeable... ios){//可变参数(...)，因为InputStream OutputStream 都实现了Closeable接口
		for(Closeable io:ios){
			try {
				if (io != null) {
					io.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		//文件到文件
		try {
			InputStream is = new FileInputStream("gg.txt");
			OutputStream os = new FileOutputStream("gg-copy.txt");
			copy(is,os);
		} catch (IOException e) {
			e.printStackTrace();
		}//源头不用写了，FileInputStream构造器自己new
		
		byte[] datas = null;
		//文件到字节数组
		try {
			InputStream is = new FileInputStream("srcPic.jpg");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is,os);
			datas = os.toByteArray();//这步别忘了，去内存里取数据
			System.out.println(datas.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//字节数组到文件
		try {
			InputStream is = new ByteArrayInputStream(datas);
			OutputStream os = new FileOutputStream("srcPic3.jpg");
			copy(is,os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}/*本来是FileNotFoundException，FileNotFoundException是FileInputStream和FileOutputStream的构造器带过来的，
由于是IOException的子类，直接用其父类即可*/
