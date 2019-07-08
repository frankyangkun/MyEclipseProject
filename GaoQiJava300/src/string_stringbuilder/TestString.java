package string_stringbuilder;

public class TestString {

	public static void main(String[] args) {
		String str = "aaabbb";
		String str2 = str.substring(2,5);//新生成一个字符串对象
		System.out.println(str);//原字符串不变
		System.out.println(str2);
		System.out.println("###########");
		//编译器做了优化，直接在编译时将字符串进行拼接
		String aa = "hello" + " java";//注意有空格，相当于aa = "hello java";
		String bb = "hello java";
		String aaa = "hello java";
		System.out.println(aa == bb);//true
		System.out.println(aaa == bb);//true
		String cc = "hello";
		String dd = "java";
		//编译的时候不知道变量中存储的是什么，所以没办法在编译时优化
		String ee = cc + dd;
		System.out.println(bb == ee);//false
	}

}
