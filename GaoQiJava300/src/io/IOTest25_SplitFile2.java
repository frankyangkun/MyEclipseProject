package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
import java.util.Vector;

import javax.sound.midi.Sequence;

/**
 * 随机流（面向对象分割文件）文件合并，使用序列流
 * @author yang
 */
public class IOTest25_SplitFile2 {
	private File src;// 源头
	private String destDir;// 目的地（文件夹）
	private List<String> destPaths;// 所有分割后的文件存储路径
	private int blockSize;// 每块大小
	private int size;// 块数：多少块

	public IOTest25_SplitFile2(String srcPath, String destDir){
		this(srcPath,destDir,1024);//默认1024
	} 
	public IOTest25_SplitFile2(String srcPath, String destDir, int blockSize){
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
	
	/**
	 * 文件的合并
	 * @throws IOException 
	 */
	public void merge(String destPath) throws IOException{
		//输出流
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));//true，追加
		Vector<InputStream> vi = new Vector<InputStream>();//容器，用来存储输入流
		SequenceInputStream sis = null;//初始化序列流
		//输入流
		for(int i = 0;i<destPaths.size();i++){//注意是destPaths，不是destPath
//			InputStream is = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
			vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
			//拷贝 分段读
//			byte[] flush = new byte[1024];
//			int len = -1;//接收长度
//			while((len=is.read(flush))!=-1){
//				os.write(flush,0,len);//分段写出
//			}
//			os.flush();
//			is.close();
		}
		sis = new SequenceInputStream(vi.elements());
		//拷贝 分段读
		byte[] flush = new byte[1024];
		int len = -1;//接收长度
		while((len=sis.read(flush))!=-1){
			os.write(flush,0,len);//分段写出
		}
		os.flush();
		sis.close();
		os.close();//注意输出流在for外关闭，因为for里面文件还没写完
	}
	public static void main(String[] args) throws IOException {
		IOTest25_SplitFile2 sp = new IOTest25_SplitFile2("xx.txt","dest",5);
		sp.split();
		sp.merge("merge.txt");
	}
}