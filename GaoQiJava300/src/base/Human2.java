package base;
//测试封装123
public class Human2{
	private int age;
	String name;
	protected int height;
	
	void sayAge(){
		System.out.println(age);
	}
}
class Boy2 extends Human2{
	void sayHello(){
//		System.out.println(age);//不能调用父类私有属性和方法
	}
}