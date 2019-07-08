package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络爬虫原理+模拟浏览器
 * @author yang
 *
 */
public class N04_SpiderTest02 {
	public static void main(String[] args) throws Exception {
		//获取url
		URL url = new URL("https://www.dianping.com");
		//下载资源（模拟浏览器）
//		InputStream is = url.openStream();
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");//模拟浏览器get请求
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
//		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));//这里不用CommonsIO，复习一下原来的写法
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String msg = null;
		while(null!=(msg=br.readLine())){
			System.out.println(msg);
		}
		br.close();
		//分析（暂时不考虑）
		//处理（暂时不考虑）
	}
}
