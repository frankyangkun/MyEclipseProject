package designmode.prototype;

import java.util.Date;
/**
 * 测试深复制
 * @author yang
 */
public class Sheep2 implements Cloneable{
	private String sname;
	private Date birthday;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();//直接调用object对象的clone()方法！
		
		//添加如下代码实现深复制（deep Clone）
		Sheep2 s = (Sheep2) obj;
		s.birthday = (Date)this.birthday.clone();//把属性也进行克隆
		return obj;
	}
	public Sheep2() {
	}
	public Sheep2(String sname, Date birthday) {
		super();
		this.sname = sname;
		this.birthday = birthday;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
