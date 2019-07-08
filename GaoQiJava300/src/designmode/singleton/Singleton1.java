package designmode.singleton;
/**
 * 测试饿汉式单例模式 
 * @author yang
 */
public class Singleton1 {
	//由于后面可能不会使用这个对象，所以白加载了，特别是加载比较耗时的话，因此懒加载（延时加载）更好，用的时候再加载
	private static Singleton1 instance = new Singleton1();//饿汉式：类初始化时对象立即被加载 
	private Singleton1(){
	}
	public static Singleton1 getInstance(){
		return instance;
	}//不需加synchronized，因为创建instance对象时是在类初始化时就立刻加载，而类加载器加载它的时候是天然的线程安全模式
}	

