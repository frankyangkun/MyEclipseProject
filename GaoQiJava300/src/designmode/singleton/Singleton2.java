package designmode.singleton;
/**
 * 测试懒汉式单例模式 
 * @author yang
 */
public class Singleton2 {
	//懒汉式：类初始化时，不初始化这个对象，延时加载，真正用的时候再创建
	private static Singleton2 instance;
	private Singleton2(){
	}
	public static synchronized Singleton2 getInstance(){
		if(instance==null){
			instance = new Singleton2();
		}
		return instance;//如果不为空，就不新建对象了，直接返回原有对象
	}
}//由于初始化时instance并没有赋值，所以可能会有多线程同步问题，可能会创建多个实例，因此需要加上同步


