package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 通过文件字节输入输出流，实现文件拷贝
 * @author yang
 *
 */
public class IOTest05_CopyFile {
	public static void main(String[] args) {
		copy("gg.txt","xx.txt");
		copy("srcPic.jpg","CopyPic2.jpg");
	}
	public static void copy(String srcPath,String descPath){
		File src = new File(srcPath);
		File dest = new File(descPath);
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest,true);
			int length = -1;
			//分段读取
			byte[] flush = new byte[1024];
			while((length=is.read(flush))!=-1){
				//分段读取
				String str = new String(flush,0,length);//不是flush.length，是length
				System.out.println(str);
				//写出到别的文件
//				byte[] datas = str.getBytes();//这步又忘了，应该可以直接用flush，因为读取后放到了flush，已经是byte类型，无需再转一次
//				os.write(datas,0,datas.length);
				os.write(flush,0,length);//分段写出
				os.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{//释放资源，分别关闭，先打开的后关闭
			try {
				if(os!=null){
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void copy2(String srcPath,String descPath){
		//创建源
		File src = new File(srcPath);
		File dest = new File(descPath);
//		//选择流
//		InputStream is = null;
//		OutputStream os =null;
		try(InputStream is = new FileInputStream(src);
			OutputStream os	= new FileOutputStream(dest,true);) {//选择流
//			is = new FileInputStream(src);
//			os	= new FileOutputStream(dest,true);
			int length = -1;
			//分段读取
			byte[] flush = new byte[1024];
			while((length=is.read(flush))!=-1){
				//分段读取
				String str = new String(flush,0,length);//不是flush.length，是length
				System.out.println(str);
				//写出到别的文件
//				byte[] datas = str.getBytes();//这步又忘了，应该可以直接用flush，因为读取后放到了flush，已经是byte类型，无需再转一次
//				os.write(datas,0,datas.length);
				os.write(flush,0,length);//分段写出
				os.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//用了try with resource（jdk1.7以后才有），去掉finally，内部自动释放try()里的is和os
	}
}
