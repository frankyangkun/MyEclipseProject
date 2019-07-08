package designmode.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下五种创建单例模式的效率
 * @author yang
 */
public class Client4 {
	public static void main(String[] args) throws Exception{
		long start = System. currentTimeMillis();
		int threadNum = 10;//线程数
		//注意为什么要用CountDownLatch，因为10个线程是在main线程里面另起的，main线程并不会等待其他10个线程运行完了再停止，它们都是独立的，所以直接算时间是不准的
	    //帮助我们观察其他的线程是否执行完，其实就是个计数器
		CountDownLatch countDownLatch = new CountDownLatch(threadNum);//视频里加了final，因为内部类和外部生命周期不同，但我不加也没报错
		
		for (int i = 0; i < threadNum; i++) {//10个线程
			new Thread(new Runnable(){//用匿名内部类实现
				@Override
				public void run() {
					for (int i = 0; i < 100000; i++) {//每个线程调用10w次方法
						Object o = Singleton4.getInstance();
//						Object o5 = Singleton5.INSTANCE;//枚举式
					}
					countDownLatch.countDown();//每执行完一个线程计数器就-1
				}
			}).start();
		}
		countDownLatch.await();//main线程阻塞，等待其他线程执行完，直到计数器变为0，才会继续往下执行！
		long end = System.currentTimeMillis();
		System.out.println("总耗时："+(end-start)+"ms");
	}
}
