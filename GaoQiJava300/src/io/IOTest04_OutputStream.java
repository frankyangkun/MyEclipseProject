package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 * 文件字节输出流
 * 1、创建源
 * 2、选择流
 * 3、操作（写出内容）
 * 4、释放资源
 * @author yang
 *
 */
public class IOTest04_OutputStream {
	public static void main(String[] args) {
		//1、创建源
		File dest = new File("xx.txt");//自动创建不存在的文件
		//2、选择流
		OutputStream os = null;
		try{
			os = new FileOutputStream(dest,true);//true是追加，false是覆盖
			//3、操作（写出）
			String msg = "china3\n";
			byte[] datas = msg.getBytes();//字符串->字节数组（编码）必须有这步，否则write无法操作，因为write需要传字节数组类型byte[]
			os.write(datas,0,datas.length);//全部写入，所以是datas.length
			os.flush();//养成习惯，写出时刷新，避免内容驻留内存
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//4、释放资源
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
