package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 模拟倒计时
 * @author yang
 *
 */
public class T12_BolckedSleep3{
	
	public static void main(String[] args) throws InterruptedException {
		//倒计时
		Date endTime = new Date(System.currentTimeMillis()+1000*10);//倒数10s，当前时间+10s
		long end = endTime.getTime();//当前时间
		while(true){
			System.out.println(new SimpleDateFormat("hh:mm:ss").format(endTime));
			Thread.sleep(1000);
			endTime=new Date(endTime.getTime()-1000);//每隔1s打印1次时间，也就是设置到的倒计时时间（比当前时间多10s）-1s
			if(end-10000>endTime.getTime()){//如果超过10s，就停下来.
				break;
			}
		}
	}
	public static void test() throws InterruptedException {
		//倒数10个数
		int num=10;
		while(true){
			Thread.sleep(1000);
			System.out.println(num--);
		}
	}
}
