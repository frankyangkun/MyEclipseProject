package io;

import java.io.File;
import java.io.IOException;

/**
 * 其他
 * createNewFile():不存在才创建文件
 * delete():删除已经存在的文件
 * @author yang
 *
 */
public class FileDemo05 {

	public static void main(String[] args) throws IOException {
		File src = new File("/Users/yang/Downloads/临时的/测试文件夹/frank.txt");
		boolean flag = src.createNewFile();//可能创建失败（文件存在就创建失败），所以需要处理异常，这里抛出
		System.out.println(flag);//不带后缀也是文件，不是文件夹
		boolean flag2 = src.delete();
		System.out.println(flag2);
		
		//文件名不能和操作系统设备名重复，比如con，com3，不过mac系统没问题，应该是windows的问题
		src = new File("/Users/yang/Workspaces/MyEclipse 2017 CI/GaoQiJava-300/com");
		boolean flag3 = src.createNewFile();
		System.out.println(flag3);
		
		
	}
}
