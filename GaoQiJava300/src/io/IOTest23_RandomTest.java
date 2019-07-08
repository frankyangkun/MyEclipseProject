package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
/**
 * 随机流（面向对象分割文件）
 * @author yang
 *
 */
public class IOTest23_RandomTest {
	public static void main(String[] args) throws IOException {
		//分多少块
		File src = new File("CopyPic.jpg");
		//总长度
		long len = src.length();
		//每块大小
		int blockSize = 1024;
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
	
	/**
	 * 指定第i块的起始位置和实际长度（封装test2）
	 * @param i
	 * @param beginPos
	 * @param actualSize
	 * @throws IOException
	 */
	public static void split(int i,int beginPos,int actualSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("CopyPic.jpg"), "r");
		RandomAccessFile raf2 = new RandomAccessFile(new File("dest/"+i+"CopyPic.jpg"), "rw");
		//随机读取 指定读取位置
		raf.seek(beginPos);
		//读取
		byte[]	flush = new byte[1024];
		int len = -1;
		while((len = raf.read(flush))!=-1){
			if(actualSize>len){
//				System.out.println(new String(flush,0,len));
				raf2.write(flush,0,len);//写文件
				actualSize-=len;
			}else{
//				System.out.println(new String(flush,0,actualSize));
				raf2.write(flush,0,actualSize);//写文件
				break;
			}
		}
		raf2.close();
		raf.close();
	}
}