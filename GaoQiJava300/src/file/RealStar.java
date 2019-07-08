package file;

import designmode.proxy.dynamicproxy.Star;

/**
 * 真实角色
 * @author yang
 */
public class RealStar implements Star{
	@Override
	public void confer() {
		System.out.println("RealStar.confer()");
	}
	@Override
	public void signContract() {
		System.out.println("RealStar.signContract()");
	}
	@Override
	public void bookTicket() {
		System.out.println("RealStar.bookTicket()");
	}
	@Override
	public void sing() {
		System.out.println("RealStar(歌手本人).sing()");
	}
	@Override
	public void collectMoney() {
		System.out.println("RealStar.collectMoney()");
	}
}
