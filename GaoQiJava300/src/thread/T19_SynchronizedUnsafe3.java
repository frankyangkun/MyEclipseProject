package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全，操作容器
 * @author yang
 *
 */
public class T19_SynchronizedUnsafe3{
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}).start();
		}
		System.out.println(list.size());
	}
}
