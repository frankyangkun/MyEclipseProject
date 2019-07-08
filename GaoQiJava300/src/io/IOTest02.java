package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * 标准代码
 * @author yang
 *
 */
public class IOTest02 {
	public static void main(String[] args) {
		//1、创建源
		File src = new File("gg.txt");
		//2、选择流
		InputStream is = null;//由于释放操作放到了finally，所以is不能定义在try中了，需提升作用域
		try {
			is = new FileInputStream(src);//因为和外接存在联系所以可能有FileNotFoundException异常
			//3、操作(读取)
			int temp;
			while((temp=is.read())!=-1){//文件末尾才是-1，否则返回的是字节代码
				System.out.println((char)temp);
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