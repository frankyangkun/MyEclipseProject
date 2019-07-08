package oop2;
//接口的基本用法
public class TestInterface {

	public static void main(String[] args) {
		Volant v = new Angel();
		v.fly();//因为类型是Volant，所以编译器把它当做Volant，只有fly方法
		
		Honest v2 = new Goodman();
		v2.helpOther(); 			
	}
}
/**
 * 飞行接口
 * @author yang
 *
 */
interface Volant{
	int FLY_HEIGHT = 1000;
	void fly();
}
/**
 * 善良接口
 * @author yang 
 *
 */
interface Honest{
	void helpOther();
	
}

class Angel implements Volant,Honest{//实现类可以实现多个父接口

	@Override
	public void helpOther() {
		// TODO Auto-generated method stub
		System.out.println("Angle.helpOther().");
	}
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Angle.fly()");
	}
}

class Goodman implements Honest{
	@Override
	public void helpOther() {
		// TODO Auto-generated method stub
		System.out.println("Goodman.fly()");
	}
	
}