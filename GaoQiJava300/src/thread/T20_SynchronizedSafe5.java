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
public class T20_SynchronizedSafe5 implements Runnable{
	//票数
	private int ticketNumber = 10;
	private boolean flag = true;
	@Override
	public void run() {
		while(flag){
			test5();
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
	
	public void test2(){//改成同步块
		synchronized(this){
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
	}
	//线程不安全，ticketNumber对象在变，对象在变跟对象的属性在变是两个不同的概念
	public void test3(){//改成同步块
		synchronized((Integer)ticketNumber){//同步传的是引用类型，所以强转一下
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
	}
	public void test4(){//缩小同步块的范围，范围太小，锁不住
		synchronized(this){
			if(ticketNumber<=0){
				flag = false;
				return;
			}
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+"票号："+ticketNumber--);//每次票数-1
	}
	public void test5(){//线程安全：尽可能锁定合理的范围（不是指代码，指数据的完整性）
		//double checking 检测临界值情况
		if(ticketNumber<=0){//考虑的是没有票的情况
			flag = false;
			return;
		}
		synchronized(this){
			if(ticketNumber<=0){//考虑的是最后1张票的情况
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
	}
	public static void main(String[] args) {
		//一份资源
		T20_SynchronizedSafe5 web = new T20_SynchronizedSafe5();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web,"代理1").start();
		new Thread(web,"代理2").start();
		new Thread(web,"代理3").start();
	}
}
