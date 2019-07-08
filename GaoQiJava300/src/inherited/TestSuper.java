package inherited;

class FatherClass{
	public int value;
	public void f(){
		value = 100;
		System.out.println("FatherClass.value="+value);
	}
}
class ChildClass extends FatherClass{
	public int value;
	public void f(){//重写父类的f方法
		super.f();//父类的这个方法在子类已经被重写覆盖，可用super调用覆盖之前的父类方法（父类的方法本身并没有改变）
		value = 200;
		System.out.println("ChildClass.value="+value);
		System.out.println(value);
		System.out.println(super.value);//调用父类对象的成员变量,没赋值，默认是0
	}
}
public class TestSuper {
	public static void main(String[] args) {
//		ChildClass cc = new ChildClass();
//		cc.f();//或简写成下面这样:
		new ChildClass().f();
	}
}