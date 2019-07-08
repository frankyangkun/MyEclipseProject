package oop;

public class Student {
	String id;
	String name;
	int age;
	Computer comp;
	
	void study(){
		System.out.println("studing..."+comp.brand);
	}
	
	public static void main(String[] args) {
		Student st = new Student();
		st.id = "st1001";
		st.name = "frank";
		st.age = 22;
		
		Computer com = new Computer();
		com.brand = "mac";
	
		st.comp = com;//把电脑对象赋值给学生对象的comp属性；
		st.study();
	}

}
class Computer{
	String brand;
}
