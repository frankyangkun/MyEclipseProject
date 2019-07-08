package oop;
//构造方法重载,重载方式跟方法的重载一样。
public class Constructor {
	int id;
	String name;
	String pwd;

	public Constructor(){
		
	}
	public Constructor(int id, String name){
//		super();//构造方法第一句总是super()，可省略
		this.id = id;
		this.name = name;
	}
	public Constructor(int id, String name, String pwd){
//		this.id = id;
//		this.name = name;
		this(id,name);
		this.pwd = pwd;
	}
	public static void main(String[] args) {
		Constructor con1 = new Constructor();
		Constructor con2 = new Constructor(101,"frank1");
		Constructor con3 = new Constructor(102,"frank2","123456");
	}
}
//class aa{//构造器私有后就不能在别的类中new了
//	Constructor con1 = new Constructor();
//	Constructor con2 = new Constructor(101,"frank1");
//	Constructor con3 = new Constructor(102,"frank2","123456");
//}