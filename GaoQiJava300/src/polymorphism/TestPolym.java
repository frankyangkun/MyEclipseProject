package polymorphism;
//测试多态

class Animal{
	public void shout(){
		System.out.println("叫了一声。");
	}
}
class Dog extends Animal{
	public void shout(){//重写shout方法
		System.out.println("旺旺旺。。。");
	}
	public void seeDoor(){
		System.out.println("看门！！");
	}
}
class Cat extends Animal{
	public void shout(){
		System.out.println("喵喵喵。。。");
	}
}
public class TestPolym {
	static void animalCry(Animal a){//父类引用指向子类对象（为了方便调用，写成static方法）
		a.shout();
	}
	public static void main(String[] args) {
		Animal a = new Animal();
//		a.animalCay();//写错了，animalCry是static，不需要对象调用，直接调用，就算是没有static，也应该是TestPolm对象调用
		animalCry(a);
		Cat c = new Cat();
		animalCry(c);
//		Dog d = new Dog();
		Animal d = new Dog();//也可写成Animal
		animalCry(d);//父类引用（Animal的某个对象）指向子类Dog对象，调用子类对象重写的父类shout方法，多态出现
//		d.seeDoor();//由于此时编译器认为d是Animal类型，因此无法识别seeDoor方法，需强转为Dog类型
		
		Dog d2 = (Dog)d;
		d2.seeDoor();
		
//		Animal c2 = new Cat();
//		Dog c3 = (Dog)c2;//编译通过，但运行会报ClassCastException类型转换异常，所以不能这么用。
//		c3.seeDoor();
	}
}