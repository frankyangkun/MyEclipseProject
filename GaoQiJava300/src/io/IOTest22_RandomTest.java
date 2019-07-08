package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
/**
 * 随机流（面向过程分割文件）
 * @author yang
 *
 */
public class IOTest22_RandomTest {
	public static void main(String[] args) throws IOException {
		//分多少块
		File src = new File("xx.txt");
		//总长度
		long len = src.length();
		//每块大小
		int blockSize = 5;
		//块数：多少块
		//len*1.0转成double，1.0保留1位小数，Math.ceil向上取整，因为最后一块如果有小数，取大，比如3.5，就取4.0，然后int强转成4
		int size = (int) Math.ceil(len*1.0/blockSize);
		System.out.println("块数："+size);//块数
		//起始位置和实际大小
		int beginPos = 0;
		int actualSize = (int) (blockSize>len?len:blockSize);//如果每块大小比总大小大，取总大小，否则取每块大小，long赋值给int，强转
		for (int i = 0; i < size; i++) {//开始分块
			beginPos = i*blockSize;
			if(i==size-1){//最后一块
				actualSize = (int)len;
			}else{
				actualSize = blockSize;
				len-=actualSize;//总长度=每次循环分块后的剩余量（越来越少）
			}
			System.out.println(i+"-->"+"从"+beginPos+"开始-->"+"实际大小："+actualSize);
			split(i,beginPos,actualSize);
		}
	}
	//指定起始位置，读取剩余所有内容
	public static void test1() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(new File("xx.txt"), "r");
		//随机读取 指定读取位置
		raf.seek(2);//从位置2开始读取
		//读取
		byte[]	flush = new byte[1024];
		int len = -1;
		while((len = raf.read(flush))!=-1){
			System.out.println(new String(flush,0,len));
		}
		raf.close();
	}
	//分块思想：起始位置，实际大小
	public static void test2() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("xx.txt"), "r");
		//起始位置
		int beginPos = 2;
		//实际大小
		int actualSize = 5;
		//随机读取 指定读取位置
		raf.seek(beginPos);
		//读取
		byte[]	flush = new byte[2];
		int len = -1;
		while((len = raf.read(flush))!=-1){
			if(actualSize>len){
				System.out.println(new String(flush,0,len));
				actualSize-=len;
			}else{
				System.out.println(new String(flush,0,actualSize));
				break;
			}
		}
		raf.close();
	}
	
	/**
	 * 指定第i块的起始位置和实际长度（封装test2）
	 * @param i
	 * @param beginPos
	 * @param actualSize
	 * @throws IOException
	 */
	public static void split(int i,int beginPos,int actualSize) throws IOException {//参数i没什么用，可以去掉
		RandomAccessFile raf = new RandomAccessFile(new File("xx.txt"), "r");
		//随机读取 指定读取位置
		raf.seek(beginPos);
		//读取
		byte[]	flush = new byte[2];
		int len = -1;
		while((len = raf.read(flush))!=-1){
			if(actualSize>len){
				System.out.println(new String(flush,0,len));
				actualSize-=len;
			}else{
				System.out.println(new String(flush,0,actualSize));
				break;
			}
		}
		raf.close();
	}
}