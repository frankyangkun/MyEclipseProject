package oop2;

public interface MyInterface {
	int MAX_AGE = 100;
	void test();

}

class MyClass implements MyInterface{

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println(MAX_AGE);
		System.out.println("MyClass.test()");
	}
	
}
