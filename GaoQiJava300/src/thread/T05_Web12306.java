package thread;
/**
 * 共享资源
 * @author yang
 *
 */
public class T05_Web12306 implements Runnable{
	//票数
	private int ticketNumber = 99;
	@Override
	public void run() {
		while(true){
			if(ticketNumber<0){
				break;
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
		T05_Web12306 web = new T05_Web12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web,"代理1").start();
		new Thread(web,"代理2").start();
		new Thread(web,"代理3").start();
	}
}
