package thread;
/**
 * 模拟龟兔赛跑，sleep模拟休息
 * @author yang
 *
 */
public class T12_BolckedSleep2 implements Runnable{
	private String winner;//胜利者
	@Override
	public void run() {
		for (int step = 1; step <= 100; step++) {
			if(Thread.currentThread().getName().equals("兔子") && step%10==0){//模拟兔子睡觉
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"-->"+step);
			//比赛是否结束
			boolean flag = gameOver(step);
			if(flag){
				break;
			}
		}
	}
	private boolean gameOver(int step){
		if(winner!=null){//存在胜利者
			return true;
		}else{
			if(step==100){
				winner = Thread.currentThread().getName();
				System.out.println("winner=="+winner);
				return true;
			}
		}
		return false;	
	}
	public static void main(String[] args) {
		T12_BolckedSleep2 r = new T12_BolckedSleep2();
		new Thread(r,"乌龟").start();
		new Thread(r,"兔子").start();
	}
}
