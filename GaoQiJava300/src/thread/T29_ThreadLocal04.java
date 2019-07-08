package thread;
/**
 * InheritableThreadLocal：继承上下文，环境的数据 起点
 * @author yang
 */
public class T29_ThreadLocal04 {
	private static ThreadLocal<Integer> threadlocal = new InheritableThreadLocal<Integer>();// 方法2.使用lambda表达式，因为只有一行，可省略return和{}
//	private static ThreadLocal<Integer> threadlocal = new ThreadLocal<>();
	public static void main(String[] args) {
		threadlocal.set(2);
		System.out.println(Thread.currentThread().getName() + "-->" + threadlocal.get());
		
		//此线程是main线程开辟的，所以相当于它的子线程，因此会把数据拷贝一份给子线程，子线程也可以修改
		new Thread(()->{
			System.out.println(Thread.currentThread().getName() + "-->" + threadlocal.get());
		}).start();
	}
}