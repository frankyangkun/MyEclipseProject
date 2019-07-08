package thread;
/**
 * 创建线程方式1：
 * 1、创建：继承Thread+重写run
 * 2、启动：创建子类对象+start
 * @author yang
 *
 */
public class T01_StartThread extends Thread{
	public void run(){
		for (int i = 0; i < 20; i++) {
			System.out.println("run方法：coding");
		}
	}
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println("主方法：听歌");
		}
		//启动
		T01_StartThread st = new T01_StartThread();
		st.start();
//		st.run();
		
	}
}
