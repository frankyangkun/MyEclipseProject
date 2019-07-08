package thread;
/**
 * DCL单例模式：懒汉式套路基础上加入并发控制，保证在多线程环境下，对外存在一个对象
 * 1、构造器私有化--避免外部new构造器
 * 2、提供私有的静态属性--存储对象的地址
 * 3、提供公共的静态方法--获取属性
 * 懒汉式是指应用启动时并不会初始化相应的实例，而是在第一次使用时加载，也就是所谓的延时加载吧
 * 饿汉式是指应用启动时就初始化相应的实例
 * @author yang
 */
public class T28_DoubleCheckLocking {
	//2、提供私有的静态属性
	private static volatile T28_DoubleCheckLocking instance;//没有volatile的话，其他线程可能会访问到一个没有初始化的对象（指令重排）
	//1、构造器私有化
	private T28_DoubleCheckLocking(){
		
	}
	//3、提供公共的静态方法--获取属性
	public static T28_DoubleCheckLocking getInstance(){
		//再次检测
		if(null!=instance){//避免不必要的同步，比如已经存在对象   
			return instance;
		}
		synchronized (T28_DoubleCheckLocking.class) {//注意.class的含义，代表获取T28_DoubleCheckLocking类的对象
			if(null == instance){
				instance = new T28_DoubleCheckLocking();//可能会发生指令重排
			}
		}
		return instance;
	}
	
	public static T28_DoubleCheckLocking getInstance1(long time){//如果不加双重检测和同步控制
		//再次检测
//		if(null!=instance){//避免不必要的同步，比如已经存在对象
//			return instance;
//		}
//		synchronized (T28_DoubleCheckLocking.class) {
			if(null == instance){
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new T28_DoubleCheckLocking();
			}
//		}
		return instance;
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			System.out.println(T28_DoubleCheckLocking.getInstance());
		});
		t.start();
		System.out.println(T28_DoubleCheckLocking.getInstance());
	}

}
