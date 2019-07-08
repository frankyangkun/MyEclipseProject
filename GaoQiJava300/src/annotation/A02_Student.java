package annotation;

@StudentTable("tb_student")//和名为tb_student的表对应
public class A02_Student {
	@StudentField(columnName="id",type="int",length=10)
	private int id;
	
	@StudentField(columnName="sname",type="varchar",length=10)
	private String name;
	
	@StudentField(columnName="age",type="int",length=3)
	private int age;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
