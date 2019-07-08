package base;
//测试static
public class TestStatic {
	int id;
	String name;
	String pwd;
	
	static String company = "成都四方";
	
	public TestStatic(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public void login(){
		printCompany();//普通方法调静态没问题
		System.out.println("login:"+ name);
	}
	
	public static void printCompany(){
//		login();//static方法内调用非静态方法会报错
		System.out.println(company);
	}
	public static void main(String[] args) {
		TestStatic ts = new TestStatic(101, "frank");
		ts.login();//非静态方法需对象调用
		TestStatic.company = "cdsf";//直接用类名给静态变量重新赋值
		TestStatic.printCompany();//静态方法类名调用
	}

}
