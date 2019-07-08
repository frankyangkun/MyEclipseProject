package thread;
/**
 * 取票，共享资源，线程不安全
 * 数据有负数和相同的
 * @author yang
 *
 */
public class T19_SynchronizedUnsafe implements Runnable{
	//票数
	private int ticketNumber = 100;
	private boolean flag = true;
	@Override
	public void run() {
		while(flag){
			test();
		}
	}
	public void test(){
		if(ticketNumber<0){
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
		T19_SynchronizedUnsafe web = new T19_SynchronizedUnsafe();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web,"代理1").start();
		new Thread(web,"代理2").start();
		new Thread(web,"代理3").start();
	}
}
