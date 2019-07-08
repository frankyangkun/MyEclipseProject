package designmode.singleton;

public class Client {
	public static void main(String[] args) {
		Singleton4 s1 =Singleton4.getInstance();//构造器私有，不能new，只能通过方法获取对象
		Singleton4 s2 =Singleton4.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		
		Singleton5 e1 = Singleton5.INSTANCE;
		Singleton5 e2 = Singleton5.INSTANCE;
		System.out.println(e1==e2);
	}
}
