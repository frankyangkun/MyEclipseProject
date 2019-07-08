package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1、图片读取到字节数组 
 * 2、字节数组写出到文件
 * @author yang
 */
public class IOTest10_PicToByteArray {

	public static void main(String[] args) {
		//图片转成字节数组
		byte[] datas = fileToByteArray("srcPic.jpg");
		System.out.println(datas.length);//566921,和图片实际大小一样，说明此时内存中有566921 字节（磁盘上的 569 KB）
		byteArrayToFile(datas,"srcPic2.jpg");
	}

	/**
	 * 图片读取到字节数组 
	 * 1、图片到程序FileInputStream 
	 * 2、程序到字节数组ByteArrayOutputStream
	 */
	public static byte[] fileToByteArray(String filePath) {
		// 1、创建源与目的地
		File src = new File(filePath);
		byte[] dest = null;//实际都没用上，直接返回了，这个dest只是用来接收存到内存中的内容，比如把存到内存的拿出来dest = baos.toByteArray();
		// 2、选择流
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			is = new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			// 3、操作(分段读取)
			byte[] flush = new byte[1024 * 10];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				// 字节数组-->字符串（解码）
				baos.write(flush,0,len);//写出到字节数组中
			}
			baos.flush();//就不去释放baos了
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4、释放资源
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		return null;//其他情况
	}

	/**
	 * 字节数组写出到图片 
	 * 1、字节数组读取到程序中ByteArrayInputStream
	 * 2、程序写出到文件FileOutputStream
	 */
	public static void byteArrayToFile(byte[] src, String filePath) {
		//1、创建源，源已经有了
		File dest = new File(filePath);//目的地
		//2、选择流
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new ByteArrayInputStream(src);
			os = new FileOutputStream(dest);//这里不用true，不追加
			//3、操作(分段读取)
			byte[] flush = new byte[10];//字节用byte[]，字符用的是char[] flush = new char[1024]
			int len = -1;
			while((len=is.read(flush))!=-1){
				os.write(flush,0,len);//写出到文件
			}
			os.flush();
		}catch (IOException e) {//去掉FileNotFoundException了
			e.printStackTrace();
		}finally{
			//4、文件流FileOutputStream要释放，ByteArrayInputStream可以不用释放
			try{
				if(os != null){
					os.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
