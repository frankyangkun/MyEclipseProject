package thread;
/**
 * yield礼让 ，暂停线程，直接进入就绪状态，不是阻塞状态
 * 用lambda测试
 * @author yang
 *
 */
public class T13_YieldDemo02{
	public static void main(String[] args) {
		new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println("lambda.."+i);
			}
		}).start();
		
		for (int i = 0; i < 100; i++) {//主线程
			if(i%20==0){
				Thread.yield();//当是20的倍数时，礼让lambda线程先执行
			}
			System.out.println("main.."+i);
		}
	}
}
