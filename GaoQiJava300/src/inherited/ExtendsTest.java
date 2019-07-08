package inherited;

class Person{
	String name;
	int height;
	
	public void rest(){
		System.out.println("hava a rest...");
	}
}
class Student2 extends Person{
	String major;
	
	public Student2(String name,int height,String major){
		this.name = name;
		this.height = height;
		this.major = major;
	}
	public void study(){
		System.out.println("studing...");
	}
}

public class ExtendsTest {
	public static void main(String[] args) {
		Student2 s = new Student2("tom", 170,"计科系");
		s.study();
		s.rest();
		System.out.println(s instanceof Student2);
		System.out.println(s instanceof Person);
		System.out.println(s instanceof Object);
		System.out.println(new Person() instanceof Student2);
	}
}
