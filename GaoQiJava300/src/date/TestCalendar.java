package date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 测试日期类的使用
 * @author yang
 *
 */
public class TestCalendar {
	//按格式打印日期
	public static void printCalendar(Calendar c){
		//打印：1918年10月10日 11:23:45 周三
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;//0-11
		int date = c.get(Calendar.DAY_OF_MONTH);
		int dayweek = c.get(Calendar.DAY_OF_WEEK)-1;//1-7(1:周日，2:周一，3：周二...)
		String dayweek2 = dayweek==0?"日":dayweek+"";//如果是0，则输出‘日’，其余输出数字（dayweek+""是把数字转成字符串）
		
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		System.out.println(year+"年"+month+"月"+date+"日"+hour+"时"+minute+"分"+second+"秒"+"\t周"+dayweek2);
		
	}
	public static void main(String[] args) {
		//获得日期的相关元素
		Calendar calendar = new GregorianCalendar(2999,10,9,22,10,50);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);//也可用DAY_OF_MONTH
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("year:"+year);
		System.out.println("month:"+month);
		System.out.println("day:"+day);
		System.out.println("weekday:"+weekday);
		
		//设置日期的相关元素
		Calendar c2 = new GregorianCalendar();
		System.out.println("before set c2:"+c2);//不设置默认就是当前日期
		c2.set(Calendar.YEAR, 8012);
		System.out.println("after set c2:"+c2);//设置年后就是新的日期年
		
		//日期的计算
		Calendar c3 = new GregorianCalendar();
		c3.add(Calendar.YEAR, -100);//往前100年
		System.out.println("c3:"+c3);
		
		//日期对象和时间对象的转化
		Date d4 = c3.getTime();//日历对象转成时间对象
		Calendar c4 = new GregorianCalendar();
		c4.setTime(new Date());//时间对象转成日期类
		System.out.println("c4:"+c4);
		printCalendar(c4);
	}

}
