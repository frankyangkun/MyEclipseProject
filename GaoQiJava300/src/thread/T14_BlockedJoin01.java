package thread;
/**
 * join：合并线程，插队线程
 * 用lambda测试
 * @author yang
 *
 */
public class T14_BlockedJoin01{
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println("lambda.."+i);
			}
		});
		t.start();
		
		for (int i = 0; i < 100; i++) {//主线程
			if(i==20){
//				Thread.yield();//当是20的倍数时，礼让lambda线程先执行
				t.join();//插队，main线程被阻塞
			}
			System.out.println("main.."+i);
		}
	}
}
