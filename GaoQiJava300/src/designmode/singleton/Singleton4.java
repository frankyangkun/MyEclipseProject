package designmode.singleton;
/**
 * 测试静态内部类实现单例模式
 * @author yang
 *这种方式：线程安全，调用效率高，并且实现了延时加载
 */
public class Singleton4 {
	private static class SingletonClassInstance{
		private static final Singleton4 instance = new Singleton4();
	}//跟饿汉式不同，并不是初始化类时就new实例，而是调用时new的，不会造成浪费
	private Singleton4() {
	}
	/*方法没有同步，调用效率高，因为加同步是因为方法体是新建实例的操作，
	 * 可能出现多线程环境下新建出多个实例的情况，这里没有新建，直接返回实例，
	 * 所以不存在同步问题，是线程安全的
	 */
	public static Singleton4 getInstance(){
		return SingletonClassInstance.instance;
	}
}
