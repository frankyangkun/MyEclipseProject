package oop2;
/**
 * 测试非静态内部类
 * @author yang
 *
 */
public class TestInnerClass {
	public static void main(String[] args) {
		//创建内部类对象
		Outer.Inner inner = new Outer().new Inner();//因为内部类是依托于外部类的，所以必须先new外部类对象才能new内部类对象
		inner.show();
	}
}
class Outer{
	private int age = 10;
	
	public void testOuter(){
		System.out.println("testOuter");
	}
	//普通内部类中不能定义static方法或属性，除非定义成静态内部类
	class Inner{//成员内部类（成员内部类分为静态和非静态，此类为后者）
		int age = 20;
		public void show(){
			int age = 30;
			System.out.println("外部类成员变量age："+Outer.this.age);//Outer.this代表外部类对象
			System.out.println("内部类成员变量age："+Inner.this.age);//Inner.this代表内部类对象，或直接this.age
			System.out.println("内部类成员变量age："+this.age);
			System.out.println("局部变量age："+age);
		}
	}
}