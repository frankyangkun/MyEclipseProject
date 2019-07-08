package regex;

import java.util.Arrays;

/**
 * 测试正则表达式对象的分割字符串的操作
 * @author yang
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		String str = "a,b,c";
		String[] newstr = str.split(",");
		System.out.println(newstr);//是个对象地址，需要转成数组打印
		System.out.println(Arrays.toString(newstr));//[a, b, c]
		
		String str2 = "a23b11c";//按数字边界进行分割
		String[] newstr2 = str2.split("\\d+");
		System.out.println(newstr2);//是个对象地址，需要转成数组打印
		System.out.println(Arrays.toString(newstr2));//[a,b,c]
		
		//Demo02中需要分组的例子，就不能用这种方法
		String str3 = "ad22fas&&89aa237##wefw234";
		String[] newstr3 = str3.split("([a-z]+)(\\d+)");
		System.out.println(newstr3);
		System.out.println(Arrays.toString(newstr3));
	}	
}	
