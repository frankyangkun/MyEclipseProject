package oop2;

/**
 * 测试字符串类的基本用法
 * 
 * @author yang
 *
 */
public class TestString {
	public static void main(String[] args) {
		String aaa = "aaa";
		String bbb = new String("ddd");
		String ccc = "aa"+"xx";
		String ddd = "18"+19;//不是加法，是字符串连接符
		System.out.println(ddd);
		
		System.out.println("##########");
		String eee = "frank";
		String fff = "frank";
		String ggg = new String("frank");
		
		System.out.println(eee==fff);//true
		System.out.println(eee==ggg);//false
		//==对比的是对象地址是否一样，我们对比字符串一般是对比值是否相等，所以一般用equals
		System.out.println(eee.equals(ggg));
	}
}
