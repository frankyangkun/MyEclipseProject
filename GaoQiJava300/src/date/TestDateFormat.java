package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间对象和字符串之间的相互转化
 * DateFormat和SimpleDateFormat
 * @author yang
 *
 */
public class TestDateFormat {

	public static void main(String[] args) throws ParseException {
		//把时间对象按照“格式字符串指定的格式”转成相应的字符串
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//抽象类DateFormat不能被new，用的是它的子类SimpleDateFormat
		String str = df.format(new Date());//把当前日期转成字符串
		String str2 = df.format(new Date(8000000));//随便试个毫秒数，看下是什么日期
		System.out.println(str);//2018-12-28 02:48:55
		System.out.println(str2);//1970-01-01 10:13:20
		
		//把字符串按照“格式字符串指定的格式”转成相应的时间对象
		DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
		Date date = df2.parse("1988年4月12日 10时45分43秒");//需要捕捉异常，我们这里抛出，返回Date类型，用Date接收
		System.out.println(date);
		
		//测试其他的格式字符
		DateFormat df3 = new SimpleDateFormat("D");//D，获取本时间对象是所处年份的第几天
		String str3 = df3.format(new Date());
		System.out.println(str3);//362
	}
}
