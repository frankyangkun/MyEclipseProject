package thread;

/**
 * ThreadLocal：每个线程自身的数据，更改不会影响其他线程
 * 
 * @author yang
 *
 */
public class T29_ThreadLocal02 {
	
	private static ThreadLocal<Integer> threadlocal = ThreadLocal.withInitial(() -> 1);// 方法2.使用lambda表达式，因为只有一行，可省略return和{}

	public static class MyRun implements Runnable {
		@Override
		public void run() {
			Integer left = threadlocal.get();//剩下多少数据
			System.out.println(Thread.currentThread().getName() + "得到了-->" + left);
			threadlocal.set(left-1);
			System.out.println(Thread.currentThread().getName() + "还剩下-->" + threadlocal.get());
		}
	}
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new MyRun()).start();
		}
	}
}
