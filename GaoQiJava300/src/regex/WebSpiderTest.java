package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络爬虫取链接
 * @author yang
 *
 */
public class WebSpiderTest {
	public static void main(String[] args) {
		String destStr = getURLContent("https://news.163.com","gbk");
		
//		Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");//取超链接整个的内容
//		Pattern p2 = Pattern.compile("href=\".+?\"");//加个问号，不然全部显示成一行了，.+?表示最小匹配，在遇到"前，匹配任意字符任意次数
//		List<String> result = getMatcherSubstrs(destStr,"href=\"(.+?)\"");//.+有点太宽了，还是有一些不需要的，比如javaScript和#开头的
		List<String> result = getMatcherSubstrs(destStr,"href=\"([^!j#][\\w\\s./:]+?)\"");//只匹配\\w\\s./:字符,且非字母j和#开头[^!j]
		for (String temp : result) {
			System.out.println(temp);
		}
	}
	
	/**
	 * 根据所给正则表达式匹配结果并返回
	 * @param destStr
	 * @param regexStr
	 * @return
	 */
	public static List<String> getMatcherSubstrs(String destStr,String regexStr){
		Pattern p3 = Pattern.compile(regexStr);//使用预搜索（零宽断言），或者分组来匹配http的内容，这里是分组例子
		Matcher m = p3.matcher(destStr);
		List<String> res = new ArrayList<String>();
		while(m.find()){
//			System.out.println(m.group());//打印整个匹配的结果
//			System.out.println(m.group(1));//只打印匹配结果中的一部分
			res.add(m.group(1));
		}
		return res;
	}
	/**
	 * 获得urlStr对应的网页源码内容
	 * @param urlStr
	 * @return
	 */
	public static String getURLContent(String urlStr,String charset){
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			InputStream is = url.openStream();//打开输入流，通过输入流把内容取到本地
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,Charset.forName(charset)));//可以复习下io的内容，指定编码，否则乱码
			String temp = "";
			while(((temp=reader.readLine())!=null)){
//				System.out.println(temp);
				sb.append(temp);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
