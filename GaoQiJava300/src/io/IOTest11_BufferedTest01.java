package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 分段读取文件字节输入流，加入缓冲流
 * 
 * @author yang 1、创建源 2、选择流 3、操作 4、释放资源
 */
public class IOTest11_BufferedTest01 {
	public static void main(String[] args) {
		// 1、创建源
		File src = new File("gg.txt");
		// 2、选择流
		InputStream is = null;
		try {
			// 直接套上缓冲流
			is = new BufferedInputStream(new FileInputStream(src));
			// 3、操作
			byte[] flush = new byte[1024];// 缓冲容器
			int len = -1;// 接收长度
			while ((len = is.read(flush)) != -1) {
				// 字节数组->字符串（编码）
				String str = new String(flush, 0, len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				// 4、释放资源
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void test1() {
		// 1、创建源
		File src = new File("gg.txt");
		// 2、选择流
		InputStream is = null;
		BufferedInputStream bis = null;// 加入缓冲流
		try {
			is = new FileInputStream(src);
			bis = new BufferedInputStream(is);// is套上bis
			// 3、操作
			byte[] flush = new byte[1024];// 缓冲容器
			int len = -1;// 接收长度
			while ((len = is.read(flush)) != -1) {
				// 字节数组->字符串（编码）
				String str = new String(flush, 0, len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != bis) {// 不需要再释放is了，bis会自动释放is
				// 4、释放资源
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
