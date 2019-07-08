package io;

import java.io.UnsupportedEncodingException;
/**
 * 编码：字符串->字节
 * @author yang
 *
 */
public class TestEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "性命生命使命a";//工程默认为utf-8字符集，1个中文占3个字节，1个英文占1个字节
		//编码：字节数组
		byte[] datas = msg.getBytes();
//		System.out.println(datas.length);//19

//		//编码：其他字符集
//		datas = msg.getBytes("UTF-16LE");//UTF-16小端表示，中英文都是2个字符，抛出UnsupportedEncodingException
//		System.out.println(datas.length);//14

//		datas = msg.getBytes("GBK");
//		System.out.println(datas.length);//13 中文2个字节，英文1个字节
//		
		//解码：字符串  把字节内容还原
		msg = new String(datas,0,datas.length,"utf8");//0表示从什么地方开始
		System.out.println(msg);
		
		//乱码
		//1、字节数不够
		msg = new String(datas,0,datas.length-2,"utf8");
		System.out.println(msg);
		
		//2、字符集不统一
		msg = new String(datas,0,datas.length-2,"gbk");//因为datas是用工程默认的字符集utf8，而这里翻译成gbk，所以乱码
		System.out.println(msg);
	}
}
