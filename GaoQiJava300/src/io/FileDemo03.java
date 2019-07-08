package io;

import java.io.File;

/**
 * 名称或路径
 * getName()
 * getPath()
 * getAbsolutePath()
 * getParent()
 * @author yang
 *
 */
public class FileDemo03 {

	public static void main(String[] args) {
		File src = new File("/Users/yang/Workspaces/MyEclipse 2017 CI/GaoQiJava-300/gg.txt");
		System.out.println("父路径："+src.getParent());
		System.out.println("路径："+src.getPath());
		System.out.println("绝对路径："+src.getAbsolutePath());
		System.out.println("文件名："+src.getName());
		System.out.println("父对象："+src.getParentFile().getName());
		System.out.println(src.exists());
		System.out.println(src.isDirectory());
		
		//文件状态的标准代码
		src = new File("xxx.png");
		if(src == null || !src.exists()){
			System.out.println("文件不存在");
		}else if(src.isFile()){
			System.out.println("文件操作");
		}else{
			System.out.println("文件夹操作");
		}
	}
}
