package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * 第一个程序：理解操作步骤
 * 1、创建源；
 * 2、选择流；
 * 3、操作流；
 * 4、释放资源
 * @author yang
 *
 */
public class IOTest01 {
	public static void main(String[] args) {
		//1、创建源
		File src = new File("gg.txt");
		//2、选择流
		try {
			InputStream is = new FileInputStream(src);//因为和外接存在联系所以可能有FileNotFoundException异常
			//3、操作(读取)
			int data1 = is.read();//第一个数据h(需处理IOException)
			int data2 = is.read();//第二个数据e
			int data3 = is.read();//第三个数据l
			int data4 = is.read();//第四个数据，没有
			System.out.println((char)data1);//需强转char，否则返回的是代号104
			System.out.println((char)data2);
			System.out.println((char)data3);
			System.out.println(data4);//文件末尾，返回-1，如果强转char，返回的是乱码
			//4、释放资源
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}