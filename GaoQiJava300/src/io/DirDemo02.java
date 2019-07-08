package io;

import java.io.File;

/**
 * 打印子孙级目录和文件名
 * @author yang
 *之前有过这个例子，讲递归算法的时候
 */
public class DirDemo02 {

	static void printFile(File f,int level){
		//输出层数
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		System.out.println(f.getName());
		if(f == null || !f.exists()){//加一个文件状态的判断
			return ;
		}else if(f.isDirectory()){
			File[] files = f.listFiles();
			 
			for(File temp:files){
				printFile(temp,level+1);
			}
		}
	}
	public static void main(String[] args) {
		File f = new File("/Volumes/Data/【学习资料】/JAVA/消息队列视频");
		printFile(f,0);
	}
}
