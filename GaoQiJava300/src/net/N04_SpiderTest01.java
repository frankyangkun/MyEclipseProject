package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 网络爬虫原理
 * @author yang
 *
 */
public class N04_SpiderTest01 {
	public static void main(String[] args) throws Exception {
		//获取url
		URL url = new URL("https://www.jd.com");
		//下载资源
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));//这里不用CommonsIO，复习一下原来的写法
		String msg = null;
		while(null!=(msg=br.readLine())){
			System.out.println(msg);
		}
		br.close();
		//分析（暂时不考虑）
		//处理（暂时不考虑）
	}
}
