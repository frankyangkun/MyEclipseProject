package thread;
/**
 * 线程安全，取钱
 * 锁定目标不对，锁定失败！！这里不是锁this，应该是锁account
 * @author yang
 *
 */
/*依然是负数，没解决问题，因为前面说了，锁的必须是对象的资源，
 * 所以这里实际上锁的是SafeDrawing里的资源，而这里test方法里是account.money，
 * 是类Account2的资源，不属于SafeDrawing，而you和he对象是类SafeDrawing的，
 * 不是类Account2的，我们需要锁的恰恰是Account2的资源，所以这里锁的目标不对，锁定失败。
*/
public class T20_SynchronizedSafe2{
	public static void main(String[] args) {
		//账户
		Account2 account = new Account2(100,"礼金");
		SafeDrawing you = new SafeDrawing(account, 80, "frank");
		SafeDrawing he = new SafeDrawing(account, 90, "tom");
		you.start();
		he.start();
	}
}
class Account2{//账户
	int money;//金额
	String name;//名称
	public Account2(int money,String name) {
		this.money = money;
		this.name = name;
	}
}
//模拟取款
class SafeDrawing extends Thread{
	Account2 account;//取钱的账户
	int drawingMoney;//取的钱数
	int packetTotal;//口袋里钱的总数
	
	public SafeDrawing(Account2 account, int drawingMoney,String name) {
		super(name);//注意这个操作，把参数name传给父类Thread构造器
		this.account = account;
		this.drawingMoney = drawingMoney;
	} 
	@Override
	public void run() {
		test();
	}
	public synchronized void test(){//锁定目标不对，锁定失败！！这里不是锁this，应该是锁account
		if(account.money-drawingMoney<0){
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account.money-=drawingMoney;
		packetTotal+=drawingMoney;
		System.out.println(this.getName()+"账户余额为："+account.money);
		System.out.println(this.getName()+"口袋的钱为："+packetTotal);
	}
}