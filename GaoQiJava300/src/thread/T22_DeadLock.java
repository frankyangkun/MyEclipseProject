package thread;

/**
 * 死锁：过多同步可能造成相互不释放资源，
 * 从而相互等待 一般发生于同步中持有多个对象的锁
 * 
 * 避免：不要在同一个代码块中，同时持有多个对象的锁
 * @author yang
 */
public class T22_DeadLock {
	public static void main(String[] args) {
		Markup m1 = new Markup(1,"frank");
		Markup m2 = new Markup(0,"tom");
		m1.start();
		m2.start();
	}
}
class Lipstick {// 口红
}
class Mirror {// 镜子
}
// 化妆
class Markup extends Thread {
	static Lipstick lip = new Lipstick();// 价格static，表示一份，无论多少对象，都只有1份，因为属于类
	static Mirror mir = new Mirror();
	int choice;
	String name;

	@Override
	public void run() {
		super.run();
		makeup();
	}
	public Markup(int choice, String name) {
		this.choice = choice;
		this.name = name;
	}
	private void makeup() {// 相互持有对方的对象锁-->可能造成死锁
		if (choice == 0) {
			synchronized (lip) {// 获得口红的锁
				System.out.println(this.name + "涂口红");
				// 1s后想拥有镜子的锁
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				synchronized (mir) {
//					System.out.println(this.name + "照镜子");
//				}
			}
			synchronized (mir) {
				System.out.println(this.name + "照镜子");
			}
		} else {
			synchronized (mir) {// 获得镜子的锁
				System.out.println(this.name + "照镜子");
				// 2s后想拥有口红的锁
				try {
					Thread.sleep(2000);// 故意形成时间间隔，才可能相互不释放资源
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				synchronized (lip) {
//					System.out.println(this.name + "涂口红");
//				}
			}
			synchronized (lip) {
				System.out.println(this.name + "涂口红");
			}
		}
	}
}