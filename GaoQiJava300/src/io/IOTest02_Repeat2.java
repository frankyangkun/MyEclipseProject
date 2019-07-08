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
public class IOTest02_Repeat2 {
	public static void main(String[] args) {
		File src = new File("gg.txt");
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			int temp;
			while((temp=is.read())!=-1){
				System.out.print((char)temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}