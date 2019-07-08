package encapsulation;
//测试封装
import base.Human2;

class Girl extends Human2{
	void sayhi(){
		System.out.println(height);//跨包的类的子类可以使用protected的属性和方法
	}
}
public class TestEncapsulation2 {

	public static void main(String[] args) {
		Human2 h = new Human2();
//		h.name = "xx";//name属性是默认修饰符，不能跨包使用
//		h.height = 11;//跨包的类不能直接调用protected的属性和方法；
		
	}

}
