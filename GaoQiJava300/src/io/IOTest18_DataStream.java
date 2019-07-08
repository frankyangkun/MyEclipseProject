package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 数据流测试（此例用字节数组来测试）
 * 1、写出后再读取
 * 2、读取的顺序与写出保持一致
 * DataOutputStream
 * DataInputStream
 * @author yang
 *
 */
public class IOTest18_DataStream {

	public static void main(String[] args) throws IOException {
		//写出 注意ByteArrayOutputStream有新方法toByteArray，所以不能多态，必须单独写一行，并且不用释放
//		DataOutputStream dos = new DataOutputStream(new ByteArrayOutputStream());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//写出到字节数组，用于读取测试，有内容才能读取，也可以写到文件
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));//加上缓冲流，提升性能
		//操作数据类型+数据，任何数据都可转成字节数组
		dos.writeUTF("测试");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas = baos.toByteArray();//去内存获取数据
		System.out.println(datas.length);//15个字节
		//读取
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//顺序与写出一致下面每一行顺序不能换，要和上面一致，否则报错
		String msg = dis.readUTF();
		int age = dis.readInt();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		System.out.println(flag);
	}
}
