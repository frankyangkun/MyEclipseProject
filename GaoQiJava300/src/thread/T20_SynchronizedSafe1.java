package thread;
/**
 * 取票，线程安全
 * 在并发时保证数据的正确性，效率尽可能高
 * 通过synchronized
 * 1、同步方法
 * 2、同步块
 * @author yang
 *
 */
public class T20_SynchronizedSafe1 implements Runnable{
	//票数
	private int ticketNumber = 100;
	private boolean flag = true;
	@Override
	public void run() {
		while(flag){
			test();
		}
	}
	public synchronized void test(){//线程安全，同步
		if(ticketNumber<=0){
			flag = false;
			return;
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+"票号："+ticketNumber--);//每次票数-1
	}
	public static void main(String[] args) {
		//一份资源
		T20_SynchronizedSafe1 web = new T20_SynchronizedSafe1();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web,"代理1").start();
		new Thread(web,"代理2").start();
		new Thread(web,"代理3").start();
	}
}
