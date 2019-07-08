package thread;
/**
 * 其他常用方法
 * @author yang
 *isAlive
 *Thread.currentThread()
 *setName 代理名称
 *getName
 *
 */
public class T18_OtherInfo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().isAlive());
		//设置名称：真实角色+代理角色
		MyInfo info = new MyInfo("战斗机");
		Thread t = new Thread(info);
//		t.setName("公鸡");//设置代理名，不设置的话默认是Thread-0
		t.start();
		Thread.sleep(1000);
		System.out.println(t.isAlive());//不等1s的话，还是true
	}
}
class MyInfo implements Runnable{
	private String name;
	public MyInfo(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+name);	
	}
}