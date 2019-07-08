package base;
//测试封装的使用细节

public class Person4 {
	private int id;
	private String name;
	private int age;
	private boolean sex;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public void setAge(int age){
		if(age >= 1 && age <= 130){ 
			this.age = age;
		}else{
			System.out.println("请输入正确年龄");
		}
	}
	public int getAge(){
		return this.age;
	}
}
