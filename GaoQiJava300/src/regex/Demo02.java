package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自己测试正则在java中的应用
 * @author yang
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//在这个字符串：adfas&&89237是否符合指定的正则表达式：\w+ （任意字母数字下划线中的一个）
		//表达式对象
		Pattern p = Pattern.compile("([a-z]+)(\\d+)");//java中凡是\就写成\\
		
		//创建匹配对象
		Matcher m = p.matcher("ad22fas&&89aa237##wefw234");
//		boolean res = m.matches();//匹配整个字符序列与该模式匹配
//		System.out.println(res);//true说明匹配上了
		
		//该方法扫描输入的序列，查找与该模式匹配的下一个子序列
//		System.out.println(m.find());//true匹配的是adfas
//		System.out.println(m.find());//true匹配的是89237
//		System.out.println(m.find());//false 因为没得匹配了
//		System.out.println(m.find());//false 因为没得匹配了
		
		while(m.find()){
			System.out.println(m.group());//m.group(),m.group(0)匹配整个表达式的子字符串
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
		
		//替换
		Pattern p2 = Pattern.compile("\\d");//或[0-9]
		Matcher m2 = p2.matcher("ad22fas&&89aa237##wefw234");
		String newStr = m2.replaceAll("*");
		System.out.println(newStr);//ad**fas&&**aa***##wefw***
		
		
	}
}
