package inherited;

//测试方法重写
class Vehicle{
	public void run(){
		System.out.println("run...");
	}
	public void stop(){
		System.out.println("stop...");
	}
	public Person whoIsPsg(){
		return new Person();
	}
}
class Horse extends Vehicle{
	 public void run(){
		 System.out.println("horse run...");
	 }
	 public Student2 whoIsPsg(){
		 return new Student2("jim", 180, "English");//重写父类中方法的子类，但不能是Object
	 }
}

public class Overwrite {

	public static void main(String[] args) {
		Horse h = new Horse();
		h.run();
	}

}
