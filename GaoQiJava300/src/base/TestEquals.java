package base;

class User{
	int id;
	String name;
	String pwd;
	public User(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())//对比类型
			return false;
		User other = (User) obj;//将obj参数强转为User类型
		if (id != other.id)//根据id来对比
			return false;
		return true;//如果前面都通过，最终返回true
	}
}
public class TestEquals {
	public static void main(String[] args) {
		User u1 = new User(1000,"frank1","123456");
		User u2 = new User(1000,"frank2","123456");

		System.out.println(u1 == u2);//false
		System.out.println(u1.equals(u2));//true 因为只根据id判断，重写前是false
		System.out.println("*******************");
		String s1 = new String("yangkun");
		String s2 = new String("yangkun");
		System.out.println(s1==s2);//false
		System.out.println(s1.equals(s2));//true
	}
}