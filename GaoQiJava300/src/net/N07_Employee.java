package net;

import java.io.Serializable;

//javabean
public class N07_Employee implements Serializable{
	private String name;
	private transient double salary;//transient代表该数据不需要序列化
	public N07_Employee() {
	}
	public N07_Employee(String name,double salary) {
		this.name = name;
		this.salary = salary;
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
}