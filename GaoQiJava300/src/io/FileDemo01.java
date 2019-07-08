package io;

import java.io.File;

/**
 * 构建对File象
 * @author yang
 *
 */
public class FileDemo01 {

	public static void main(String[] args) {
		String path = "/Users/yang/Workspaces/MyEclipse 2017 CI/GaoQiJava-300/gg.txt"; 
		//构建File对象方法1
		File src = new File(path);
		System.out.println(src);
		//构建File对象方法2 只要能拼出来即可
		src = new File("/Users/yang/Workspaces/MyEclipse 2017 CI/GaoQiJava-300/","gg.txt");
		src = new File("/Users/yang/Workspaces/MyEclipse 2017 CI","/GaoQiJava-300/gg.txt");
		System.out.println(src);
		//构建File对象方法3
		src = new File(new File("/Users/yang/Workspaces/MyEclipse 2017 CI/GaoQiJava-300/"),"gg.txt");
		System.out.println(src);
	}
}
