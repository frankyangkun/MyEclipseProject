package designmode.proxy.staticproxy;
/**
 * 测试静态代理
 * @author yang
 */
public class Client {
	public static void main(String[] args) {
		Star real = new RealStar();//真实角色
		Star proxy = new ProxyStar(real);//经纪人，代理了真实角色
		
		proxy.confer();
		proxy.signContract();
		proxy.bookTicket();
		proxy.sing();//客户找经纪人唱歌，经纪人找真实角色唱歌，但是客户并不知道，他只需要跟经纪人打交道
		proxy.collectMoney();
	}
}
