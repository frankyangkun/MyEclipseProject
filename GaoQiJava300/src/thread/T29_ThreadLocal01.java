package thread;

/**
 * ThreadLocal：每个线程自身的存储本地、局部区域 get/set/initialValue
 * 
 * @author yang
 *
 */
public class T29_ThreadLocal01 {
	// private static ThreadLocal<Integer> threadlocal = new ThreadLocal<>();
	// 更改初始值 需重写initialValue方法
	// private static ThreadLocal<Integer> threadlocal = new ThreadLocal<Integer>(){//方法1，匿名内部类
	// 		protected Integer initialValue(){
	// 			return 200;
	// 		};
	// };
	// private static ThreadLocal<Integer> threadlocal = ThreadLocal.withInitial(()->{//方法2，使用lambda表达式
	// 	return 200;
	// });

	private static ThreadLocal<Integer> threadlocal = ThreadLocal.withInitial(() -> 200);// 方法2.使用lambda表达式，因为只有一行，可省略return和{}

	public static class MyRun implements Runnable {
		@Override
		public void run() {
			threadlocal.set((int) (Math.random() * 99));
			System.out.println(Thread.currentThread().getName() + "-->" + threadlocal.get());
		}
	}

	public static void main(String[] args) {
		// 获取值
		System.out.println(Thread.currentThread().getName() + "-->" + threadlocal.get());// 初始值是null
		// 设置值
		threadlocal.set(99);
		System.out.println(Thread.currentThread().getName() + "-->" + threadlocal.get());// 99
		new Thread(new MyRun()).start();
		new Thread(new MyRun()).start();
	}
}
