package oop2;
/**
 * 测试静态内部类
 * @author yang
 *
 */
public class TestStaticInnerClass {
	public static void main(String[] args) {
		Outer2.Inner2 inner = new Outer2.Inner2();//无需依托外部类对象
	}

}
class Outer2{
	static class Inner2{//静态内部类
		
	}
	
}