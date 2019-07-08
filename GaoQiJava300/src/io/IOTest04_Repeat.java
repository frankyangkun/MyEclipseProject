package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IOTest04_Repeat {

	public static void main(String[] args) {
		File dest = new File("xx.txt");
		OutputStream os = null;
		try {
			os = new FileOutputStream(dest,true);
			String msg = "uuu";
			byte[] datas = msg.getBytes();
			os.write(datas,0,datas.length);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				os.close();//少了个if判断
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
