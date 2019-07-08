package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程安全，使用并发容器，不用自己加锁，它内部实现了
 * @author yang
 *
 */
public class T20_SynchronizedSafe4_2{
	public static void main(String[] args) throws InterruptedException {
//		List<String> list = new ArrayList<String>();
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		for (int i = 0; i < 10000; i++) {
			new Thread(()->{
//				synchronized (list) {//add的时候保证list是拿到了锁的
					list.add(Thread.currentThread().getName());
//				}
			}).start();
		}
		Thread.sleep(5000);//延时，因为前面有多个线程和main线程，线程还没运行完就在打印，还是会出现数据不对
		System.out.println(list.size());
	}
}
