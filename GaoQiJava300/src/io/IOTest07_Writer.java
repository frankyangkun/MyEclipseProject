package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
/**
 * 文件字符输出流
 * @author yang
 *
 */
public class IOTest07_Writer {
	public static void main(String[] args) {
		//1、创建源
		File src = new File("gg.txt");
		//2、选择流
		Writer writer = null;
		try {
			writer = new FileWriter(src,true);
			//3、操作(写出)
			//写法1
			String msg = "frank-写法1-20190130\r\n";
			char[] datas = msg.toCharArray();//字符串->字符数组（都是字符，就不存在编码问题了）
			writer.write(datas,0,datas.length);
			writer.flush();
			
			//写法2
			String msg2 = "frank-写法2-20190130\r\n";
			writer.write(msg2);//直接把字符串丢进去即可，也可指定写多少比如write(msg2,0,datas.length)
			writer.flush();
			
			//写法3
			writer.append("frank").append("-写法3").append("-20190130");
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//4、释放资源
			try {
				if(writer!=null){
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}