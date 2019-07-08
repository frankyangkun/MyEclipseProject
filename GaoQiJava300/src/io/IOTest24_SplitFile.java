package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/**
 * 随机流（面向对象分割文件）重新封装
 * @author yang
 */
public class IOTest24_SplitFile {
	private File src;// 源头
	private String destDir;// 目的地（文件夹）
	private List<String> destPaths;// 所有分割后的文件存储路径
	private int blockSize;// 每块大小
	private int size;// 块数：多少块

	public IOTest24_SplitFile(String srcPath, String destDir){
		this(srcPath,destDir,1024);//默认1024
	} 
	public IOTest24_SplitFile(String srcPath, String destDir, int blockSize){
		this.src = new File(srcPath);
		this.destDir = destDir;
		this.blockSize = blockSize;
		this.destPaths = new ArrayList<String>();
		// 初始化
		init();
	}
	// 初始化
	private void init() {
		// 总长度
		long len = this.src.length();
		// 块数：多少块
		this.size = (int) Math.ceil(len * 1.0 / blockSize);
		// 路径
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDir + "/"+i + "-" + this.src.getName());
		}
	}
	/**
	 * 分割 1、计算每一块的起始位置和大小 2、分割
	 * 
	 * @param args
	 * @throws IOException
	 */
	public void split() throws IOException {
		long len = src.length();// 总长度
		int beginPos = 0;// 起始位置和实际大小
		int actualSize = (int) (blockSize > len ? len : blockSize);// 如果每块大小比总大小大，取总大小，否则取每块大小，long赋值给int，强转
		for (int i = 0; i < size; i++) {// 开始分块
			beginPos = i * blockSize;
			if (i == size - 1) {// 最后一块
				actualSize = (int) len;
			} else {
				actualSize = blockSize;
				len -= actualSize;// 总长度=每次循环分块后的剩余量（越来越少）
			}
			splitDetail(i, beginPos, actualSize);
		}
	}

	/**
	 * 指定第i块的起始位置和实际长度（封装test2）
	 * 
	 * @param i
	 * @param beginPos
	 * @param actualSize
	 * @throws IOException
	 */
	private void splitDetail(int i, int beginPos, int actualSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(this.src, "r");
		RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i), "rw");
		// 随机读取 指定读取位置
		raf.seek(beginPos);
		// 读取
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
			if (actualSize > len) {
				// System.out.println(new String(flush,0,len));
				raf2.write(flush, 0, len);// 写文件
				actualSize -= len;
			} else {
				// System.out.println(new String(flush,0,actualSize));
				raf2.write(flush, 0, actualSize);// 写文件
				break;
			}
		}
		raf2.close();
		raf.close();
	}
	public static void main(String[] args) throws IOException {
		IOTest24_SplitFile sp = new IOTest24_SplitFile("xx.txt", "dest");
		sp.split();
	}
}