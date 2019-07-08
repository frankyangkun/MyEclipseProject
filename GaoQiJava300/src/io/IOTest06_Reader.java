package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
/**
 * 文件字符输入流，分段读取
 * @author yang
 *
 */
public class IOTest06_Reader {
	public static void main(String[] args) {
		//1、创建源
		File src = new File("gg.txt");
		//2、选择流
		Reader reader = null;
		try {
			reader = new FileReader(src);
			//3、操作(分段读取)操作的是字符数组，而不再是字节数组
			char[] flush = new char[1024];//1024个字符
			int len = -1;//接收长度
			while((len=reader.read(flush))!=-1){
				//现在是字符数组，不再存在字节数组-->字符串（解码）问题，直接构建成字符串
				String str = new String(flush,0,len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//4、释放资源
			try {
				if(reader!=null){
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}