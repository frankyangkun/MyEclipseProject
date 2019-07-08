package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全，操作容器
 * @author yang
 *
 */
public class T20_SynchronizedSafe4_1{
	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			new Thread(()->{
				synchronized (list) {//add的时候保证list是拿到了锁的
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		Thread.sleep(5000);//延时，因为前面有多个线程和main线程，线程还没运行完就在打印，还是会出现数据不对
		System.out.println(list.size());
	}
}
