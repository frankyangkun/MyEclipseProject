package thread;
/**
 * 创建线程方式2：
 * 1、创建：实现Runnable+重写run
 * 2、启动：创建实现类对象+start
 * @author yang
 *
 */
public class T04_StartRun implements Runnable{
	public void run(){
		for (int i = 0; i < 20; i++) {
			System.out.println("run方法：coding");
		}
	}
	public static void main(String[] args) {
		/*//创建实现类对象
		StartRun sr = new StartRun();
		//创建代理类对象
		Thread t = new Thread(sr);
		t.start();
		*/
		new Thread(new T04_StartRun()).start();//匿名写法
		
		for (int i = 0; i < 20; i++) {
			System.out.println("主方法：听歌");
		}
	}
}
