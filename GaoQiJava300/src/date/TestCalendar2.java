package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 可视化日历程序
 * @author yang
 *
 */
public class TestCalendar2 {

	public static void main(String[] args) throws ParseException {
		String str = "2020-9-10";//先转时间对象，再把时间对象转日期对象
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(str);//把字符串解析成时间对象，需抛异常ParseException
		
		//把时间对象date转成日期对象Calendar
		Calendar c = new GregorianCalendar();
		c.setTime(date);//到此，就把字符串转成了日期类
		
		//下面开始打印
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		c.set(Calendar.DAY_OF_MONTH,1);//把当前日期置为1
		
		//因为1号不见得是周日，所以需要算一下是周几，如果是周一，前面加一个制表符
		
		for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK)-1; i++) {//如果是周四，Calendar.DAY_OF_WEEK的结果是5，所以要-1
			System.out.print("\t");//如果是周四，前面就会循环打印4次制表符，效果就出来了
		}
		int days = c.getActualMaximum(Calendar.DATE);//必须单独提出来，不能写在for里，否则会多打印天数
		for (int i = 1; i <= days; i++) {//getActualMaximum获取月份最大天数
			System.out.print(c.get(Calendar.DAY_OF_MONTH)+"\t");//前面设置了，这里来获取
			if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){//也可直接写成7
				System.out.println();//换行
			}
			c.add(Calendar.DAY_OF_MONTH,1);//每打印1次，日期+1天，如果没这一步，打印全是1
		}
	}
}
