package oop2;

public class TestString2 {
	public static void main(String[] args) {
		String s1 = "core Java";
		String s2 = "Core Java";
		System.out.println(s1.charAt(3));//提取下标为3的字符
		
		System.out.println(s2.length());//字符串长度
		
		System.out.println(s1.equals(s2));//比较字符串值是否相等
		System.out.println(s1.equalsIgnoreCase(s2));//比较字符串值，忽略大小写
		
		System.out.println(s1.indexOf("Java"));//s1是否包含“Java”
		System.out.println(s1.indexOf("Java2"));
		
		String s = s1.replace(' ', '&');//替换后的s是新的字符串，原有s1不受影响（不可变字符序列）
		System.out.println("result is"+s);
		
		System.out.println("#############");
		String ss = "";
		String ss1 = "How are you?";
		
		System.out.println(ss1.startsWith("How"));//是否以How开头
		System.out.println(ss1.endsWith("you"));//是否以you结尾
		
		ss1 = ss1.substring(4);//提取下标以后的字符串
		System.out.println(ss1);
		ss1 = ss1.substring(4,7);//提取下标字符串，不包括下标7
		System.out.println(ss1);
		
		ss1 = ss1.toLowerCase();//转小写
		System.out.println(ss1);
		ss1 = ss1.toUpperCase();
		System.out.println(ss1);//转大写
		
		String jj = " How old are you? ";
		String jj3 = jj.trim();//去掉字符串收尾空格，中间空格不能去除。
		System.out.println(jj3);
		System.out.println(jj);//String是不可变字符串，所以不影响原有jj字符串
	}
}
