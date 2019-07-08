package io;

import java.io.File;

/**
 * 创建目录
 * mkdir()：必须确保上级目录存在，否则创建失败
 * mkdirs():上级目录可以不存在，不存在一同创建，推荐使用
 * 
 * 列出下一级
 * list():列出下级名称
 * listFiles():列出下级File对象
 * @author yang
 *
 */
public class DirDemo01 {

	public static void main(String[] args) {
		File src = new File("/Users/yang/Downloads/临时的/测试文件夹/dir/test");
		boolean flag = src.mkdir();//因为dir目录不存在，所以失败
		System.out.println(flag);//false
		
		boolean flag2 = src.mkdirs();//dir目录不存在，一同创建
		System.out.println(flag2);//true
		
		File dir = new File("/Volumes/Data/【学习资料】/JAVA/2018年尚学堂_高淇_Java300集");
		//列出下级名称
		String[] subName = dir.list();
		for(String s:subName){
			System.out.println(s);
		}
		//列出下级对象
		File[] subFiles = dir.listFiles();
		for(File s:subFiles){
			System.out.println(s.getAbsolutePath());
		}
		//列出所有盘符
		File[] roots = dir.listRoots();
		for(File root:roots){
			System.out.println(root.getAbsolutePath());//mac系统，只有/一个根，如果是windows，可能是C:\,D:\这样
		}
	}
}
