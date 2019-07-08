package string_stringbuilder;
/**
 * 测试StringBuilder，StringBuffer可变字符序列常用方法
 * @author yang
 *
 */
public class TestStringBuilder2 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			char temp = (char)('a'+i);
			sb.append(temp);
		}
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.setCharAt(3, '杨');
		System.out.println(sb);
		sb.insert(0, '我');
		System.out.println(sb);
		sb.insert(0, '吃').insert(4, '饭').insert(7, '了');//链式调用，核心就是该方法调用了return this，把自己返回了
		System.out.println(sb);
		sb.delete(20, 23);//同样可以链式调用
		System.out.println(sb);
	}
	
	

}
