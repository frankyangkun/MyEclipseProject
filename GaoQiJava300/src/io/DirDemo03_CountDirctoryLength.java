package io;

import java.io.File;

/**
 * 统计文件夹大小
 * @author yang
 */
public class DirDemo03_CountDirctoryLength {

	private static long len = 0;
	static void count(File f){
		if(f != null || f.exists()){//递归头
			if(f.isFile()){//大小
				len+=f.length();
			}else{//子孙级
				for(File s:f.listFiles()){
					count(s);
				}
			}
		}
	}
	public static void main(String[] args) {
		File f = new File("/Volumes/Data/【学习资料】/JAVA/消息队列视频");
		count(f);
		System.out.println(len);
	}
}
