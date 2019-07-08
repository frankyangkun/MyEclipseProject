package thread;

/**
 * 线程安全，取钱
 * 使用同步块
 * @author yang
 */
/*同步监视器实际上就是“锁谁”，我们这里是要锁account，因为需要判断account的余额，不能为负，所以多线程运行时，需要对它进行监视。*/

public class T20_SynchronizedSafe3 {
	public static void main(String[] args) {
		// 账户
		Account3 account = new Account3(100, "礼金");
		SyncDrawing you = new SyncDrawing(account, 80, "frank");
		SyncDrawing he = new SyncDrawing(account, 90, "tom");
		you.start();
		he.start();
	}
}
class Account3 {// 账户
	int money;// 金额
	String name;// 名称  

	public Account3(int money, String name) {
		this.money = money;
		this.name = name;
	}
}
// 模拟取款
class SyncDrawing extends Thread {
	Account3 account;// 取钱的账户
	int drawingMoney;// 取的钱数
	int packetTotal;// 口袋里钱的总数

	public SyncDrawing(Account3 account, int drawingMoney, String name) {
		super(name);// 注意这个操作，把参数name传给父类Thread构造器
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	@Override
	public void run() {
		test();
	}
	public void test() {// 锁定目标account
		if(account.money<0){//提高多线程运行时的性能，只要账户没钱了，多线程操作时就无需再等了
			return;
		}
		synchronized (account) {// 同步块，监视器account，多线程运行时，看下account对象是否被锁，如果有，别人访问不了
			if (account.money - drawingMoney < 0) {
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.money -= drawingMoney;
			packetTotal += drawingMoney;
			System.out.println(this.getName() + "账户余额为：" + account.money);
			System.out.println(this.getName() + "口袋的钱为：" + packetTotal);
		}
	}
}