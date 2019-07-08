package io;

import java.io.File;

/**
 * 其他
 * length():文件字节数
 * @author yang
 *
 */
public class FileDemo04 {

	public static void main(String[] args) {
		File src = new File("/Users/yang/Downloads/临时的/测试文件夹/WX20181008-112356@2x.png");
		System.out.println("长度："+src.length());
		
		src = new File("/Users/yang/Downloads/临时的/测试文件夹/");
		System.out.println("长度："+src.length());
		
		src = new File("/Users/yang/Downloads/临时的");
		System.out.println("长度："+src.length());
	}
}
