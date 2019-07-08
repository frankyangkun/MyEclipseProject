package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * throws声明异常
 * @author yang
 *
 */
public class TestThrowsException {

	public static void main(String[] args) throws IOException {
		readMyFile();
	}
	
	public static void readMyFile() throws IOException{
		FileReader reader = null;
//		try {
			reader = new FileReader("/Users/yang/Downloads/1234a.xlsx");//捕获FileNotFoundException
			System.out.println("step1");
			char c1 = (char)reader.read();//捕获IOException
			System.out.println(c1);
//		} catch (FileNotFoundException e) {
//			System.out.println("step2");
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			System.out.println("step3");
//			try {
//				if(reader != null){//为了避免空指针，判断一下
//					reader.close();//捕获IOException
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}//因为reader调用的是底层操作系统的文件系统，因此这种资源需要关闭
//		}
	}
}
