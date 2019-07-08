package designmode.proxy.staticproxy;
/**
 * 经纪人（代理）
 * @author yang
 */
public class ProxyStar implements Star{
	private Star star;//需要知道是代理的哪个明星
	public ProxyStar(Star star) {
		super();
		this.star = star;
	}
	@Override
	public void sing() {
		star.sing();
	}
	@Override
	public void confer() {
		System.out.println("ProxyStar.confer()");	
	}
	@Override
	public void signContract() {
		System.out.println("ProxyStar.signContract()");
	}
	@Override
	public void bookTicket() {
		System.out.println("ProxyStar.bookTicket()");
	}
	@Override
	public void collectMoney() {
		System.out.println("ProxyStar.bookTicket()");
	}
}
