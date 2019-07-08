package oop;
//测试Object类
public class ObjectTest {
	@Override
	public String toString(){
		return "重写Object类的toString方法";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectTest ot = new ObjectTest();
		System.out.println(ot);
		System.out.println(ot.toString());
	}

}
