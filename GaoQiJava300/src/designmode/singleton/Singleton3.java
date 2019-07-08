package designmode.singleton;
/**
 * 双重检查锁，实现单例模式
 * @author yang
 *但由于编译器优化原因和jvm底层内部模型原因，偶尔会出问题，不建议使用
 *思想：使用同步块，减小粒度，只有实例为空时才同步等待，否则直接返回实例
 *平时工作用不到，了解即可
 */
public class Singleton3 {
	private static Singleton3 instance = null;
	private Singleton3() {
	}
	public static Singleton3 getInstance(){
		if(instance==null){
			Singleton3 sc;
			synchronized (Singleton3.class) {//采用同步块，减小粒度，提高效率
				sc = instance;
				if(sc==null){
					synchronized (Singleton3.class) {
						if(sc==null){
							sc = new Singleton3();
						}
					}
					instance = sc;
				}
			}
		}
		return instance;
	}
}
