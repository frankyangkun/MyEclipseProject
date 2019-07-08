package designmode.prototype;

import java.io.Serializable;
import java.util.Date;
/**
 * 测试浅复制
 * @author yang
 */
public class Sheep implements Cloneable,Serializable{
	private String sname;
	private Date birthday;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();//直接调用object对象的clone()方法！
		return obj;
	}
	public Sheep() {
	}
	public Sheep(String sname, Date birthday) {
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
