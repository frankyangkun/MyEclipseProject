package thread;
/**
 * ThreadLocal：分析上下文，环境
 * 1、构造器：哪里调用，就属于哪里，找线程体，构造器调用就属于main线程
 * 2、run方法：本线程自身的
 * @author yang
 */
public class T29_ThreadLocal03 {
	private static ThreadLocal<Integer> threadlocal = ThreadLocal.withInitial(() -> 1);// 方法2.使用lambda表达式，因为只有一行，可省略return和{}

	public static class MyRun implements Runnable {
	public MyRun() {
		threadlocal.set(-100);//修改的只是main线程的变量
		System.out.println(Thread.currentThread().getName() + "-->" + threadlocal.get());
	}
		@Override
		public void run() {//线程体，这才是开辟的子线程
			System.out.println(Thread.currentThread().getName() + "-->" + threadlocal.get());
		}
	}
	public static void main(String[] args) {
		new Thread(new MyRun()).start();//调用构造器，只修改main线程的变量
		new Thread(new MyRun()).start();
	}
}