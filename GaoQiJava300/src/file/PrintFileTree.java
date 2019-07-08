package file;

import java.io.File;

/**
 * 使用递归算法打印目录树
 * @author yang
 *
 */
public class PrintFileTree {
	static int count = 0;
	static void printFile(File f,int level){
		//输出层数
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		System.out.println(f.getName());
		
		if(f.isDirectory()){
			File[] files = f.listFiles();
			for(File temp:files){
				printFile(temp,level+1);
				count++;
			}
		}
	}
	public static void main(String[] args) {
		File f = new File("/Users/yang/Workspaces/MyEclipse2017CI/GaoQiJava300/src");
		printFile(f,0);
		System.out.println(count);
	}
}
