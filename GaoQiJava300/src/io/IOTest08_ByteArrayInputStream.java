package io;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
/**
 * 字节数组输入流
 * @author yang
 *
 */
public class IOTest08_ByteArrayInputStream {
	public static void main(String[] args) {
		//1、创建源
		byte[] src = "testByteArrayInputStream".getBytes();//字符串->字节数组（编码）
		//2、选择流
		InputStream is = null;
		try {
			is = new ByteArrayInputStream(src);
			//3、操作(分段读取)
			byte[] flush = new byte[10];//字节用byte[]，字符用的是char[] flush = new char[1024]
			int len = -1;
			while((len=is.read(flush))!=-1){
				//字节数组-->字符串（解码）
				String str = new String(flush,0,len);
				System.out.println(str);
			}
		}catch (IOException e) {//去掉FileNotFoundException了
			e.printStackTrace();
		}finally{
			//4、释放资源
			try {
				if(is!=null){
					is.close();//因为是字节数组流，不存在与os的交互，直接gc回收资源，因此close是空方法，可以不写（close是通知os释放资源的）
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}