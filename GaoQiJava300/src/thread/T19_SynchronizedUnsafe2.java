package thread;
/**
 * 线程不安全，取钱
 * @author yang
 *
 */
public class T19_SynchronizedUnsafe2{
	public static void main(String[] args) {
		//账户
		Account account = new Account(100,"礼金");
		Drawing you = new Drawing(account, 80, "frank");
		Drawing he = new Drawing(account, 90, "tom");
		you.start();
		he.start();
	}
}
class Account{//账户
	int money;//金额
	String name;//名称
	public Account(int money,String name) {
		this.money = money;
		this.name = name;
	}
}
//模拟取款
class Drawing extends Thread{
	Account account;//取钱的账户
	int drawingMoney;//取的钱数
	int packetTotal;//口袋里钱的总数
	
	public Drawing(Account account, int drawingMoney,String name) {
		super(name);//注意这个操作，把参数name传给父类Thread构造器
		this.account = account;
		this.drawingMoney = drawingMoney;
	} 
	@Override
	public void run() {
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