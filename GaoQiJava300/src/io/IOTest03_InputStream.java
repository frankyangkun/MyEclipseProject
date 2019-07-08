package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * 文件字节输入流，分段读取
 * @author yang
 *
 */
public class IOTest03_InputStream {
	public static void main(String[] args) {
		//1、创建源
		File src = new File("gg.txt");
		//2、选择流
		InputStream is = null;//由于释放操作放到了finally，所以is不能定义在try中了，需提升作用域
		try {
			is = new FileInputStream(src);//因为和外接存在联系所以可能有FileNotFoundException异常
			//3、操作(分段读取)
			byte[] flush = new byte[1024];//缓冲容器，一般是1kb（1kb=1024byte）来做缓冲，后面可以乘以倍数*
			int len = -1;//接收长度
			while((len=is.read(flush))!=-1){//读取到car里，read(char[] cbuf)返回的是int，长度。而read()返回的是实际的数据，代号；
				//字节数组-->字符串（解码）
				String str = new String(flush,0,len);//从car的0处开始，每次读len长度
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//4、释放资源
			try {
				if(is!=null){//为了避免is还没创建成功就报异常，最后执行finally会出空指针异常，所以加个判断
					is.close();//只有用到了is资源才释放，创建都不成功就不用释放
				}
			} catch (IOException e) {
				e.printStackTrace();
			}//如果读取出问题了，就直接进异常了，无法释放了，所以释放应该放在finally中
		}
	}
}