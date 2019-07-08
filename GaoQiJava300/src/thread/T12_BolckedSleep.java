package thread;
/**
 * sleep模拟网络延时，放大了发生问题的可能性
 * @author yang
 *
 */
public class T12_BolckedSleep implements Runnable{
	//票数
	private int ticketNumber = 99;
	@Override
	public void run() {
		while(true){
			if(ticketNumber<0){
				break;
			}
			//模拟延时
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
		T12_BolckedSleep web = new T12_BolckedSleep();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web,"代理1").start();
		new Thread(web,"代理2").start();
		new Thread(web,"代理3").start();
	}
}
