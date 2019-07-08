package annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 注解
 * @author yang
 *
 */
@SuppressWarnings("all")
public class A01_Demo01 {
	
	@Override
	public String toString(){
		return "";
	}
	@Deprecated
	public static void test2(){
		
	}
//	@SuppressWarnings("all")//忽略所有告警
	public static void test3(){
		List list = new ArrayList();
		List list2 = new ArrayList();
		List list3 = new ArrayList();
	}
	public static void main(String[] args) {
		Date date = new Date();
		date.parse("");
		test2();
	}
}
