package thread;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class T24_TimeTest1 {
	public static void main(String[] args) {
		Timer time = new Timer();
		//执行安排
//		time.schedule(new MyTask(), 1000);//执行1次，延时1s执行
//		time.schedule(new MyTask(), 1000,200);//执行多次，每隔200ms执行一次，不会停
		Calendar cal = new GregorianCalendar(2019,4,13,21,10,10);//在2019年04月13日21:10:10执行
		time.schedule(new MyTask(), cal.getTime(),200);
	}
}
//任务类
class MyTask extends TimerTask{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("a");
		}
		System.out.println("end1..");
	}
}