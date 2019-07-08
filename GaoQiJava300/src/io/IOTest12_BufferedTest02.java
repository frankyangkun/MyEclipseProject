package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件字节输出流，加入缓冲流
 * 
 * @author yang 1、创建源 2、选择流 3、操作 （写出内容） 4、释放资源
 */
public class IOTest12_BufferedTest02 {
	public static void main(String[] args) {
		// 1、创建源
		File desc = new File("gg.txt");
		// 2、选择流
		OutputStream os = null;
		try {
			// 直接套上缓冲流
			os = new BufferedOutputStream(new FileOutputStream(desc));
			// 3、操作（写出）
			String msg = "IO is so easy.";
			byte[] datas = msg.getBytes();// 字符串-->字节数组（编码）
			os.write(datas, 0, datas.length);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != os) {
				// 4、释放资源
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
