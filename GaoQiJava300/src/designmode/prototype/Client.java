package designmode.prototype;

import java.util.Date;

/**
 * 测试原型模式（克隆模式）--浅克隆
 * @author yang
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date d = new Date(12345123L);
		Sheep s1 = new Sheep("frank",d);
		System.out.println(s1);
		System.out.println(s1.getSname()+s1.getBirthday()+"老时间");
		
		d.setTime(1111333333L);//修改时间
		System.out.println(s1.getSname()+s1.getBirthday()+"新时间");
		Sheep s2 = (Sheep) s1.clone();//克隆对象
		System.out.println(s2);
		System.out.println(s2.getSname()+s2.getBirthday());
		
		//也可修改原型的值
		s2.setSname("Tony");
		System.out.println(s2.getSname()+s2.getBirthday());//虽然是新对象，但s1修改时间后再运行，s2的时间也变成新时间了
	}
}
