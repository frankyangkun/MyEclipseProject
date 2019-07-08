package inherited;
//关于继承树的问题

class FatherClass2{
	public FatherClass2(){
		System.out.println("开始创建一个FatherClass...");
	}
}
class ChildClass2 extends FatherClass2{
	public ChildClass2(){
		System.out.println("开始创建一个ChildClass...");
	}
}
public class TestSuper2 {

	public static void main(String[] args) {
		System.out.println("开始创建一个ChildClass对象...");
		ChildClass2 cc = new ChildClass2();
	}  
}
