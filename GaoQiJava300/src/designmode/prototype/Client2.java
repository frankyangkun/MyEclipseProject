package designmode.prototype;

import java.util.Date;

/**
 * 原型模式（深复制）
 * @author yang
 */
public class Client2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date d = new Date(12345123L);
		Sheep2 s1 = new Sheep2("frank",d);
		Sheep2 s2 = (Sheep2) s1.clone();//克隆对象
		
		System.out.println(s1);
		System.out.println(s1.getSname()+s1.getBirthday()+"老时间");
		
		d.setTime(1111333333L);//修改时间
		System.out.println(s1.getSname()+s1.getBirthday()+"新时间");
		
		System.out.println(s2);
		System.out.println(s2.getSname()+s2.getBirthday()+"克隆时间");
		
		//也可修改原型的值
		s2.setSname("Tony");
		System.out.println(s2.getSname()+s2.getBirthday());
	}
}
