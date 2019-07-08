package thread;
/**
 * 协作模型：生产者消费者实现方式二：信号灯法
 * 借助标志位
 * @author yang
 *
 */
public class T23_WaitTest2 {
	public static void main(String[] args) {
		Tv tv = new Tv();
		new Player(tv).start();
		new Watcher(tv).start();
	}
}
//生产者 演员
class Player extends Thread{
	Tv t;
	public Player(Tv t) {
		this.t = t;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if(i%2==0){
				this.t.play("奇葩说");
			}else{
				this.t.play("广告");
			}
		}
	}
}
//消费者 观众
class Watcher extends Thread{
	Tv t;
	public Watcher(Tv t) {
		this.t = t;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			t.watch();
		}
	}
}
//同一个资源 电视
class Tv{
	String voice;
	//信号灯
	//True表示演员表演，观众等待
	//False表示观众观看，演员等待
	boolean flag = true;
	//表演
	public synchronized void play(String voice){
		//演员等待
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("表演了"+voice);
		this.voice = voice;
		//唤醒
		this.notifyAll();
		//切换标志
		this.flag = !this.flag;
	}
	//观看
	public synchronized void watch(){
		//演员等待
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("听到了"+voice);//观看
		//唤醒
		this.notifyAll();
		//切换标志
		this.flag = !this.flag;
	}
}