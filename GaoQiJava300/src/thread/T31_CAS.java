package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:比较并交换
 * 先跟原来的值比较，如果原来的值没有动过，就交换，如果动过了就交换失败
 * @author yang
 *
 */
public class T31_CAS {
	//库存，不能直接用Integer，而要用“原子性的Integer”，凡是带Atomic的一般都有原子操作
	//CAS里面不是用的synchronized这种锁，而是cas思想
	private static AtomicInteger stock = new AtomicInteger(5);
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(()->{
				try {
					Thread.sleep(1000);//模拟延时
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//decrementAndGet内部就用到了cas思想，硬件指令，即用当前值和原值先比较，如果相等，就用新值覆盖，否则更新失败
				Integer left = stock.decrementAndGet();
				if(left<1){
					System.out.println(Thread.currentThread().getName()+"商品抢完了.");
					return;
				}
				System.out.println(Thread.currentThread().getName()+"抢了一件商品，还剩"+left);
			}).start();
		}
	}
}
