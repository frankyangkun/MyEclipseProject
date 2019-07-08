package javassist;

@Author(name="Chiba",year=2005)
public class Emp {
	private String ename;
	private int empno;
	
	public Emp(String ename, int empno) {
		super();
		this.ename = ename;
		this.empno = empno;
	}

	public Emp() {
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public void sayHi(int a){
		System.out.println("hello"+a);
	}
	
}
