package thread;
/**
 * 终止线程 
 * 1、线程正常执行完毕--次数 
 * 2、外部干涉--加入标识 
 * 不要使用stop和destroy
 * @author yang
 */
public class T11_TerminateThread implements Runnable {
	// 1、加入标识，标记线程体是否可以运行
	private boolean flag = true;
	private String name;

	public T11_TerminateThread(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		// 2、关联标识
		int i = 0;
		while (flag) {
			System.out.println(name + "->" + i++);
		}
	}
	// 3、对外提供方法改变标识
	public void ternimate() {
		this.flag = false;
	}
	public static void main(String[] args) {
		T11_TerminateThread tt = new T11_TerminateThread("frank");
		new Thread(tt).start();
		for (int i = 0; i < 99; i++) {
			System.out.println("main->" + i);
			if (i == 88) {
				tt.ternimate();// 线程的终止
				System.out.println("game over.");
			}
		}
	}
}
/*注意：i=88不代表立即停止运行，所以main会运行完98次，因为两条路径，
 * 当88的时候main只是去调用标志位，而线程循环到while的时候，判断flag是不是等于false，
 * 如果是false，线程体run方法里的东西就为空了，相当于空线程了，也就相当于终止线程了。
 * 而主线程main是会执行完98次的*/