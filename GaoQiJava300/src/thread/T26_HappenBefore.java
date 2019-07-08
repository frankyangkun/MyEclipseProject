package thread;

public class T26_HappenBefore {
	private static int a = 0;
	private static boolean flag = false;
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<100;i++){
			a = 0;//每次循环赋为初始值
			flag = false;//每次循环赋为初始值
			//线程1 更改数据
			Thread t1 = new Thread(()->{
				a = 1;
				flag = true;
			});
			//线程2 读取数据
			Thread t2 = new Thread(()->{
				if(flag){
					a *= 1;
				}
				if(a==0){//指令重排
					System.out.println("happen before."+a);
				}
			});
			t1.start();
			t2.start();
			//合并线程（插队线程）
			t1.join();
			t2.join();
		}
	}
}
