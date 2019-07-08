package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * io标准代码，练习
 * @author yang
 *
 */
public class IOTest02_Repeat5 {
	public static void main(String[] args) {
		File src = new File("gg.txt");
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			int length = -1;
			byte[] datas = new byte[3];
			while((length=is.read(datas))!=-1){
				String str = new String(datas,0,datas.length);//这句忘记了
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}