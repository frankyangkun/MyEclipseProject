package testorm;
/**
 * 表结构和类对应
 * @author yang
 *
 */
public class Emp {
	private Integer id;//最好用包装类，int也行
	private String empname;
	private Integer age;
	private Double salary;
	private Double birthday;
	private Integer deptId;
	
	public Emp() {//空构造器必须有
	}
	public Emp(Integer id, String empname, Integer age, Double salary, Double birthday, Integer deptId) {
		super();
		this.id = id;
		this.empname = empname;
		this.age = age;
		this.salary = salary;
		this.birthday = birthday;
		this.deptId = deptId;
	}
	public Emp(String empname, Double salary,Integer age) {
		super();
		this.empname = empname;
		this.age = age;
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getBirthday() {
		return birthday;
	}
	public void setBirthday(Double birthday) {
		this.birthday = birthday;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
}
