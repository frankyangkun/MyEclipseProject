package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试表格数据的存储
 * 体会ORM思想
 * 每一行数据使用javabean对象存储，多行使用放到map或list中
 * @author yang
 *
 */
public class TestStoreData2 {
	public static void main(String[] args) {
		//每行数据用1个javabean对象来表示
		User user1 = new User(1001,"张三",2000,"2008-9-3");
		User user2 = new User(1002,"李四",4000,"2009-4-1");
		User user3 = new User(1003,"王五",1000,"2002-3-12");
		
		//把javabean对象放到List
		List<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		for(User u:list){
			System.out.println(u);
		}  
		System.out.println("**********************");
		//把javabean对象放到Map
		Map<Integer,User> map = new HashMap<>();
		map.put(1001, user1);
		map.put(1002, user2);
		map.put(1003, user3);
		
		Set<Integer> keyset = map.keySet();
		for(Integer key:keyset){
			System.out.println(key+"==="+map.get(key));
		}
	}
}
class User{
	private int id;
	private String name;
	private double salary;
	private String hiredate;
	
	public User() {//一个完整的javabean，要有set和get方法，以及无参构造器！
	}

	public User(int id, String name, double salary, String hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hiredate = hiredate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "id:"+id+" name:"+name+" salary"+salary+" hiredate:"+hiredate;
	}
}