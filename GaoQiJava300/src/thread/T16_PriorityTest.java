package thread;
/**
 * 线程优先级 10个
 * 1、NORM_PRIORITY 5默认
 * 2、MIN_PRIORITY 1
 * 3、MAX_PRIORITY 10 最大值，不能超过10
 * 概率，不代表绝对的优先级
 * @author yang
 *
 */
public class T16_PriorityTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());//main-->5
		MyPriority m = new MyPriority();
		Thread t = new Thread(m);
		Thread t2 = new Thread(m);
		Thread t3 = new Thread(m);
		Thread t4 = new Thread(m);
		Thread t5 = new Thread(m);
		Thread t6 = new Thread(m);
		//设置优先级在启动前
		t.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);
		
		t.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}
class MyPriority implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());	
		Thread.yield();//要或不要这句都差不多
	}
}