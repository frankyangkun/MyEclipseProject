package file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {

	public static void main(String[] args) throws IOException {
		File f = new File("/Users/yang/Downloads/123.xlsx");//获取文件，得到一个文件对象
		System.out.println(f);//打印的是文件路径，如果要打印文件内容，需要用到IO流的知识
		f.renameTo(new File("/Users/yang/Downloads/1234.xlsx"));//改源文件名，不创建新文件
		
		//获取当前项目路径：/Users/yang/Workspaces/MyEclipse 2017 CI/GaoQiJava-300
		System.out.println(System.getProperty("user.dir"));
		File f2 = new File("gg.txt");
		f2.createNewFile();//抛出IOException 在当前项目路径下创建文件
		
		System.out.println("File是否存在："+f2.exists());
        System.out.println("File是否是目录："+f2.isDirectory());
        System.out.println("File是否是文件："+f2.isFile());
        System.out.println("File最后修改时间："+new Date(f2.lastModified()));
        System.out.println("File的大小："+f2.length());
        System.out.println("File的文件名："+f2.getName());
        System.out.println("File的目录路径："+f2.getAbsolutePath());
		
        File f3 = new File("d:/电影/华语/大陆");
//        boolean flag = f3.mkdir(); //目录结构中有一个不存在，则不会创建整个目录树
        boolean flag = f3.mkdirs();//目录结构中有一个不存在也没关系；创建整个目录树
        System.out.println(flag);//创建失败
	}
}
