package collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap2 {

	public static void main(String[] args) {
		Employee e1 = new Employee(1001,"frank1",10000);
		Employee e2 = new Employee(1002,"frank2",20000);
		Employee e3 = new Employee(1003,"frank3",30000);
		Employee e4 = new Employee(1001,"frank4",40000);
		System.out.println("e1:"+e1.hashCode());
		System.out.println(e1.hashCode()%15);
		Map<Integer,Employee> map = new HashMap<>();
		map.put(1001, e1);
		map.put(1002, e2);
		map.put(1003, e3);
		map.put(1001, e4);
		
		Employee emp = map.get(1001);
		System.out.println(emp.getEname());
		System.out.println(emp.getId());
		System.out.println(emp.getSalary());
	}

}
class Employee{
	private int id;
	private String ename;
	private double salary;
	
	public Employee(int id, String ename, double salary) {
		super();
		this.id = id;
		this.ename = ename;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String toString(){
		return "id:"+id+" name:"+ename+" salary:"+salary;
	}
	
}