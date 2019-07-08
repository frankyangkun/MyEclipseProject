package io;

import java.io.File;
import java.io.IOException;

/**
 * 使用面向对象统计文件大小
 * @author yang
 *
 */
public class DirCount {
	//大小
	private long len;
	//文件个数
	private int FileSize;
	//文件夹个数
	private int DirSize;
	//文件夹路径
	private String path;
	//数据源
	File src;
	
	public DirCount(String path) {
		this.path = path;
		this.src = new File(path);//这个是新建的，不需要传参
		count(this.src);
		System.out.println("@@@@"+this.src);
	}
	//统计大小
	private void count(File f){
		if(f != null || f.exists()){//递归头
			if(f.isFile()){//大小
				len+=f.length();
				this.FileSize++;
			}else{//子孙级
				this.DirSize++;
				File[] next = f.listFiles();
//				for(File s:f.listFiles()){
				if(next != null){
					for(File s:next){
						count(s);
					}
				}else{		
					throw new RuntimeException("文件或文件夹不存在！");
				}
			}
		}
	}
	public long getLen() {//用来输出文件大小
		return len;
	}
//	public void setLen(long len) {//只要get方法就行
//		this.len = len;
//	}
	public int getFileSize() {
		return FileSize;
	}
	public int getDirSize() {
		return DirSize;
	}
	public static void main(String[] args) {
		DirCount dir = new DirCount("/Volumes/Data/【学习资料】/JAVA/消息队列视频");//新建对象在构造器中完成了
		System.out.println(dir.getLen());//不要直接输出变量，用get方法更规范
		System.out.println("文件夹个数："+dir.getDirSize());
		System.out.println("文件个数："+dir.getFileSize());
		DirCount dir2 = new DirCount("/Volumes/Data/【学习资料】/JAVA/消息队列视频/1ActiveMQ RabbitMQ RokcetMQ Kafka实战 消息队列中间件视频教程/Kafka");
		System.out.println(dir2.getLen());
		System.out.println("文件夹个数："+dir2.getDirSize());
		System.out.println("文件个数："+dir2.getFileSize());
	}
}
