package string_stringbuilder;
/**
 * 测试StringBuilder和StringBuffer
 * @author yang
 *
 */
public class TestStringBuilder {
	public static void main(String[] args) {
		//StringBuilder线程不安全，效率高（一般用它），StringBuffer线程安全，效率低
		StringBuilder sb = new StringBuilder("sbsbsb");
		String ss = "sssss";
		System.out.println(Integer.toHexString(sb.hashCode()));
		System.out.println(sb);//sbsbsb
		
		System.out.println(Integer.toHexString(ss.hashCode()));
		System.out.println(ss);//sssss
		
		sb.setCharAt(2, 'M');//修改的是原来的sb
		String sss = ss.replace('b', 'x');//String类型修改后是返回一个新字符串
		System.out.println(Integer.toHexString(sb.hashCode()));
		System.out.println(sb);//aaMaa
		
		System.out.println(Integer.toHexString(ss.hashCode()));//原来的内存地址不变
		System.out.println(Integer.toHexString(sss.hashCode()));//返回的新字符串地址和原来不同
		System.out.println(sss);//xxxxx
	}
}
