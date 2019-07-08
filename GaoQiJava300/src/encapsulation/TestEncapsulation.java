package encapsulation;
//测试封装

class Human{
	private int age;
	String name;
	
	void sayAge(){
		System.out.println(age);
	}
}
class Boy extends Human{
	void sayHello(){
//		System.out.println(age);//不能调用父类私有属性和方法
	}
}
public class TestEncapsulation {
	public static void main(String[] args) {
		Human h = new Human();
//		h.age = 11;//不能调用其他类的私有属性和方法
	}
}