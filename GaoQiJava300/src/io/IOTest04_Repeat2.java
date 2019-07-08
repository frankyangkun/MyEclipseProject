package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IOTest04_Repeat2 {

	public static void main(String[] args) {
		File src = new File("xx.txt");
		OutputStream os = null;
		try {
			os = new FileOutputStream(src);
			String msg = "io is so easy.";
			byte[] datas = msg.getBytes();
			os.write(datas,0,datas.length);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(os != null){
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
