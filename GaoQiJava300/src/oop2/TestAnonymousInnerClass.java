package oop2;
/**
 * 测试匿名内部类
 * @author yang
 *
 */
public class TestAnonymousInnerClass { 
	public static void test01(AA a){//参数是AA接口的对象
		System.out.println("########");
		a.aa();
	}
	public static void main(String[] args) {
		TestAnonymousInnerClass.test01(new AA(){//这里是实现接口

			@Override
			public void aa() {
				// TODO Auto-generated method stub
				System.out.println("TestAnonymousInnerClass.main(...).new AA(){...}.aa()");
			}
		});
	}
}
interface AA{
	void aa();
}