package io.iocommons;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * 常用方法
 * @author yang
 *
 */
public class CIOTest01 {
	public static void main(String[] args) {
		//文件大小
		long len = FileUtils.sizeOf(new File("xx.txt"));
		System.out.println(len);
		//目录大小
		len = FileUtils.sizeOf(new File("/Users/yang/Downloads/commons-io-2.6"));
		System.out.println(len);
		//列出子孙级
		//参数2是非空文件过滤，不列出空文件
		Collection<File> file = FileUtils.listFiles(new File("/Users/yang/Workspaces/MyEclipse 2017 CI/IOCommons"),
				EmptyFileFilter.NOT_EMPTY, null);
		for (File temp : file) {
			System.out.println(temp.getAbsolutePath());//列出目录
		}
		System.out.println("---------------------------------");
		Collection<File> file2 = FileUtils.listFiles(new File("/Users/yang/Workspaces/MyEclipse 2017 CI/IOCommons"),
				EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);//操作目录的下一级
		for (File temp : file2) {
			System.out.println(temp.getAbsolutePath());//列出目录
		}
		System.out.println("---------------------------------");//列出想要类型的文件
		Collection<File> file3 = FileUtils.listFiles(new File("/Users/yang/Workspaces/MyEclipse 2017 CI/IOCommons"),
				FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class"),EmptyFileFilter.EMPTY),
				DirectoryFileFilter.INSTANCE);//操作目录的下一级
		for (File temp : file3) {
			System.out.println(temp.getAbsolutePath());//列出目录
		}
		System.out.println("---------------------------------");//列出非空且为java的文件
		Collection<File> file4 = FileUtils.listFiles(new File("/Users/yang/Workspaces/MyEclipse 2017 CI/IOCommons"),
				FileFilterUtils.and(new SuffixFileFilter("java"),EmptyFileFilter.NOT_EMPTY),
				DirectoryFileFilter.INSTANCE);//操作目录的下一级
		for (File temp : file4) {
			System.out.println(temp.getAbsolutePath());//列出目录
		}
	}
}
