package thread;
/**
 * join：合并线程，插队线程
 * @author yang
 *
 */
public class T14_BlockedJoin02{
	public static void main(String[] args){
		System.out.println("main：爸爸和儿子买烟的故事");
		new Thread(new Father()).start();
	}
}
class Father extends Thread{
	public void run(){
		System.out.println("Father：想抽烟，发现没了");
		System.out.println("Father：让儿子去买");
		Thread t = new Thread(new Son());
		t.start();
		try {
			t.join();//插队，让Son线程先执行完，Father被阻塞
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Father：儿子走丢了，老爸出去找");
		}
		System.out.println("Father：老爸接过烟");
	}
}
class Son extends Thread{
	public  void run(){
		System.out.println("Son:接过老爸的钱出去了。。。");
		System.out.println("Son:路边游戏厅玩了10s。。。");
		for (int i = 0; i < 10; i++) {
			System.out.println("Son:第"+i+"秒过去了");
		}
		System.out.println("Son:赶紧买烟");
	}
}