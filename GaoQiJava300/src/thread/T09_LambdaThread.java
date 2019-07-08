package thread;

/**
 * Lambda表达式，简化线程（用一次）的使用
 * @author yang
 */
public class T09_LambdaThread {
	// 1、静态内部类
	static class Test implements Runnable {
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("静态内部类");
			}
		}
	}
	public static void main(String[] args) {
//		new Thread(new Test()).start();
		//2、局部内部类
		class Test2 implements Runnable {
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("局部内部类");
				}
			}
		}
//		new Thread(new Test2()).start();
		//3、匿名内部类 必须借助接口或父类
		new Thread(new Runnable(){
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("匿名内部类");
				}
			}
		}).start();
		
		//4、jdk8简化 lambda表达式
		new Thread(()-> {
			for (int i = 0; i < 20; i++) {
				System.out.println("lambda表达式");
			}
		}
		).start();
	}
}
