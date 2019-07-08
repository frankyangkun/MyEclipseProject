package oop2;

public abstract class Animal {
	abstract public void shout();

	public void run(){
		System.out.println("run...");
	}
	public static void main(String[] args) {
		Animal a = new Dog();
		a.shout();
	}
}

class Dog extends Animal{

	@Override
	public void shout() {
		System.out.println("wangwangwang...");
	}
}


 