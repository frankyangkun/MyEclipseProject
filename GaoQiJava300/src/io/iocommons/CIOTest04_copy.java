package io.iocommons;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * 拷贝
 * @author yang
 *
 */
public class CIOTest04_copy {
	public static void main(String[] args) throws IOException {
		//复制文件
//		FileUtils.copyFile(new File("xx.txt"), new File("xx2.txt"));
		//拷贝文件到目录
//		FileUtils.copyFileToDirectory(new File("xx.txt"), new File("lib"));
		//拷贝目录到目录，成为它的子目录
		FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
		//拷贝目录到目录
//		FileUtils.copyDirectory(new File("lib"), new File("lib2"));
		//拷贝url内容，比如图片
//		String url = "http://s1.dgtle.com/forum/201903/29/144103r9sjud1myepjkmey.jpg";
//		FileUtils.copyURLToFile(new URL(url), new File("test.jpg"));
		//读取网页内容到字符串，指定字符集，比如百度是utf8
		String datas = IOUtils.toString(new URL("http://www.baidu.com"),"UTF-8");
		System.out.println(datas);
		
	}
}
