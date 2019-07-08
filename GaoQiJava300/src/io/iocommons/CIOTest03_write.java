package io.iocommons;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 写出内容
 * @author yang
 *
 */
public class CIOTest03_write {
	public static void main(String[] args) throws IOException {
		//写出文件
		FileUtils.write(new File("xx.txt"),"abc\r\n","UTF-8");
		FileUtils.writeStringToFile(new File("xx.txt"),"abc\r\n","UTF-8",true);//和上面效果相同
		FileUtils.writeByteArrayToFile(new File("xx.txt"),"bbb\r\n".getBytes("UTF-8"),true);//通过字节数组写出到文件
		//写出列表
		List<String> names = new ArrayList<String>();
		names.add("x");
		names.add("y");
		names.add("z");
		FileUtils.writeLines(new File("xx.txt"),names,"---", true);//---是分隔符
	}
}
