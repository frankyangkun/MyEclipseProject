package thread;
import java.lang.Thread.State;
/**
 * 观察线程的状态
 * @author yang
 */
public class T15_AllState {
	public static void main(String[] args) {
		Thread t = new Thread(()->{
//			for(int i=0;i<5;i++){
				try {
					Thread.sleep(500);//TIMED_WAITING阻塞
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//			}
			System.out.println("...");
		});
		//观察状态
		State state = t.getState();
		System.out.println(state);//NEW新生状态
		
		t.start();//启动线程
		state = t.getState();
		System.out.println(state);//就绪和运行都称作RUNNABLE
//		while(state!=Thread.State.TERMINATED){//状态为TERMINATED就退出
//			try {
//				Thread.sleep(200);//200ms监控一次
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			state = t.getState();
//			System.out.println(state);
//		}
//		state = t.getState();
//		System.out.println("end:"+state);//TERMINATED死亡状态
		
		while(true){
			int num = Thread.activeCount();//活动的线程数
			System.out.println(num);
			if(num==1){
				break;
			}
			try {
				Thread.sleep(200);//200ms监控一次
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			state = t.getState();
			System.out.println(state);
		}
		state = t.getState();
		System.out.println("end:"+state);//TERMINATED死亡状态
	}
}