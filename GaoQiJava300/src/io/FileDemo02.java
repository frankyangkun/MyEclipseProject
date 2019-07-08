package io;

import java.io.File;

/**
 * 构建对File象
 * 1、存在盘符：绝对路径
 * 2、不存在盘符：相对路径
 * @author yang
 *
 */
public class FileDemo02 {

	public static void main(String[] args) {
		String path = "/Users/yang/Workspaces/MyEclipse 2017 CI/GaoQiJava-300/gg.txt"; 
		//绝对路径
		File src = new File(path);
		System.out.println(src.getAbsolutePath());
		
		//相对路径
		System.out.println(System.getProperty("user.dir"));//以工程所在路径为基础的路径
		src = new File("gg.txt");
		System.out.println(src.getAbsolutePath());
		
		//构建不存在的文件
		src = new File("xx/gg.txt");
		System.out.println(src.getAbsolutePath());
	}
}
