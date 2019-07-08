package io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 * 字节数组输出流ByteArrayOutputStream
 * 1、创建源：（不创建，系统内部自己维护）
 * 2、选择流：（不关联源，因为无需定义源）
 * 3、操作（写出内容）：由于写到了内存中，需要toByteArray去内存中拿出来
 * 4、释放资源（可以不用）
 * @author yang
 *
 */
public class IOTest09_ByteArrayOutputStream {
	public static void main(String[] args) {
		//1、创建源
		byte[] dest = null;//保证风格统一，声明为空，其实是不用指定源的
		//2、选择流(要用到子类ByteArrayOutputStream的新增方法toByteArray)
		ByteArrayOutputStream baos = null;//因为要使用子类的新增方法toByteArray，所以不能用多态（不能用父类OutputStream声明），要用ByteArrayOutputStream
		try{
			baos = new ByteArrayOutputStream();
			//3、操作（写出）
			String msg = "show me the code.\r";
			byte[] datas = msg.getBytes();//字符串->字节数组（编码）必须有这步，否则write无法操作，因为write需要传字节数组类型byte[]
			baos.write(datas,0,datas.length);//写入字节数组datas
			baos.flush();
			//4、因为写进内存了，所以需要去内存把数据拿出来toByteArray
			dest = baos.toByteArray();
			System.out.println(dest.length+"-->"+new String(dest,0,baos.size()));//把以字节数组方式写到内存中的内容以字符形式还原出来
			System.out.println(dest.length+"-->"+new String(dest,0,dest.length));//两种都可以
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//4、释放资源
			try{
				if(baos!=null){
					baos.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
