package io;

import java.io.File;

/**
 * 测试路径
 * @author yang
 *
 */
public class PathDemo {

	public static void main(String[] args) {
		//\或/都是名称分隔符，可以用separator或separatorChar表示
		//方法1：建议使用/来分隔
		String path = "/Users/yang/Workspaces/MyEclipse 2017 CI/GaoQiJava-300/gg.txt";
		System.out.println(File.separator);
		System.out.println(File.separatorChar);
		System.out.println(path);
		//方法2：常量拼接
		path = File.separator+"Users"+File.separator+"yang"+File.separator+"Workspaces";//后面就不写了
		System.out.println(path);
	}
}
