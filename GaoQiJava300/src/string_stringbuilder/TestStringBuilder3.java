package string_stringbuilder;
/**
 * 测试可变字符序列和不可变字符序列使用的陷阱
 * @author yang
 *
 */
public class TestStringBuilder3 {

	public static void main(String[] args) {
		//使用String进行字符串的拼接
		String str = "";
		long num1 = Runtime.getRuntime().freeMemory();//获取系统剩余内存空间
		long time1 = System.currentTimeMillis();//获取系统当前时间
		
		for (int i = 0; i < 5000; i++) {
			str = str + i;//相当于产生了10000个对象（每次循环生成的拼接str和空str），不能这么用
		}
		long num2 = Runtime.getRuntime().freeMemory();//获取系统剩余内存空间
		long time2 = System.currentTimeMillis();
		System.out.println("String占用内存："+ (num1-num2));
		System.out.println("String占用时间："+ (time2-time1));
		
		//正确的写法
		StringBuilder sb1 = new StringBuilder("");
		long num3 = Runtime.getRuntime().freeMemory();
		long time3 = System.currentTimeMillis();
		
		for (int i = 0; i < 5000; i++) {
			sb1.append(i);//始终改变的是原来的字符串
		}
		long num4 = Runtime.getRuntime().freeMemory();
		long time4 = System.currentTimeMillis();
		System.out.println("StringBuilder占用内存："+ (num3-num4));
		System.out.println("StringBuilder占用时间："+ (time4-time3));
	}
}
