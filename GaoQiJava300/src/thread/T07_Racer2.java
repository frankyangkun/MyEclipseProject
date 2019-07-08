package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 模拟龟兔赛跑 Callable
 * @author yang
 *
 */
public class T07_Racer2 implements Callable<Integer>{
	private String winner;//胜利者
	@Override
	public Integer call() throws Exception{
		for (int step = 1; step <= 100; step++) {
			if(Thread.currentThread().getName().equals("pool-1-thread-1") && step%10==0){//模拟兔子睡觉	
				Thread.sleep(100);
			}
			System.out.println(Thread.currentThread().getName()+"-->"+step);
			//比赛是否结束
			boolean flag = gameOver(step);
			if(flag){
				return step;
			}
		}
		return null;
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
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		T07_Racer2 r = new T07_Racer2();
		//创建执行服务
		ExecutorService ser = Executors.newFixedThreadPool(2);
		//提交执行
		Future<Integer> res1 = ser.submit(r);
		Future<Integer> res2 = ser.submit(r);
		//获取结果
		Integer r1 = res1.get();//
		Integer r2 = res2.get();//
		System.out.println(r1+"-->"+r2);
		//关闭服务
		ser.shutdownNow();
	}
}
