package thread;
/**
 * 守护线程：是为用户线程服务的
 * jvm不必等守护线程执行结束
 * 默认情况下都是用户线程，jvm等待所有的用户线程执行完毕才会停止
 * @author yang
 *
 */
public class T17_DaemonTest {
	public static void main(String[] args) {
		God god = new God();
		Yourself y = new Yourself();
		
		new Thread(y).start();
		
		Thread t = new Thread(god);
		t.setDaemon(true);
		/*将用户线程god调整为守护线程，因为god是死循环，设置之前jvm是不会停的，一直运行，
		 * 但现在设置为守护线程，因此jvm无需等待守护线god程执行完毕，只要用户线程y执行完毕就可以停了*/
		t.start();
	}
}
class Yourself implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 365; i++) {
			System.out.println("happy life");
		}
		System.out.println("game over.");
	}
}
class God implements Runnable{
	@Override
	public void run() {
		for (;true;) {
			System.out.println("God bless you..");
		}
	}
}