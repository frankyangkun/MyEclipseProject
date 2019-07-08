package wrapperclass;
/**
 * 测试自动装箱，自动拆箱
 * @author yang
 *
 */
public class TestAutoBox {
	public static void main(String[] args) {
		Integer a = 12;//把int变量自动装箱成包装类对象，编译器自动执行Integer a = Integer.valueOf(12);
		int b = a;//自动拆箱，编译器会自动修改成：int b = a.intValue();
		
		Integer c = null;
		if(c != null){
			int d = c;//自动拆箱，会调用c.intValue(),所以会报空指针，因此要判断
		}
		
		/*
		 * 缓存[-128，127]之间的数字。实际就是系统初始的时候，创建了[-128，127]之间的
		 * 一个缓存数组。当我们调用valueOf()的时候，首先检查是否在这个范围之间，如果
		 * 在则直接从缓存中拿出，如果不在，则new一个新的Integer对象
		 */
		Integer in1 = Integer.valueOf(-128);
		Integer in2 = -128;//自动装箱，和上面一回事
		System.out.println(in1==in2);//true,因为-128在缓存范围内
		System.out.println(in1.equals(in2));//true
		System.out.println("#############");
		Integer in3 = 1234;
		Integer in4 = 1234;
		System.out.println(in3==in4);//false,因为1234不在缓存范围内
		System.out.println(in3.equals(in4));//true	
	}
}
