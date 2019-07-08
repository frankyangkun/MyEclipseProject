 package classloader;
/**
 * 测试类加载全过程_初始化时机
 * @author yang
 *
 */
public class Demo01 {
	static{
		System.out.println("静态初始化Demo01！");
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Demo01的main方法！");//最先加载的是Demo01，main方法，所以比A先打印
//		A a = new A();//主动引用1，new一个类对象
//		System.out.println(A.width);
//		A a2 = new A();//只打印“创建A类对象”，不再执行静态初始化内容
//		System.out.println(A.width);//主动引用2，会初始化A，因为访问了静态域（块，方法，属性）
//		Class.forName("classloader.A");//主动引用3，反射调用A也会初始化
		
//		System.out.println(A.MAX);//被用引用1，不会初始化类A，因为编译时常量放在了常量池里
//		A[] as = new A[10];//被动引用2，通过数组定义类引用，不会初始化
		System.out.println(B.width);//被动引用3，只会初始化域真正初始化的类A，不会初始化B
	}
}
class A extends A_Father{
	public static int width = 100;
	public static final int MAX = 300;
	static {
		System.out.println("静态初始化类A");
	}
	public A() {
		System.out.println("创建A类对象");
	}
}
class B extends A{
	static{
		System.out.println("静态初始化B");
	}
}
class A_Father{
	static{
		System.out.println("静态初始化A_Father");
	}
}