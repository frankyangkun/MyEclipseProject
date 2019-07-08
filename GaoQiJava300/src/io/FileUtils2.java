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
 *释放资源的另一种方式：try-with-resource,就不要finally了
 *跟python的with as差不多
 * @author yang
 */
public class FileUtils2 {

	/**
	 * 对接输入输出流
	 * @param is
	 * @param os
	 */
	public static void copy(InputStream is, OutputStream os) {

		try(is;os){
			// 3、操作(分段读取)
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len = is.read(flush))!=-1) {
				// 字节数组-->字符串（解码）
				os.write(flush,0,len);// 写出到字节数组中
			}
			os.flush();// 就不去释放baos了
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
