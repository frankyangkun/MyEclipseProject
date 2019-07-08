package base;
//测试静态初始化块
public class StaticBlock {
	int id;
	String name;
	String pwd;
	
	static String company;
	
	static {
		System.out.println("执行类的初始化工作");
		company = "cdsf";
		printCompany();
//		printCompany2();//静态块中不能调用普通方法
	}
	
	public static void printCompany(){
		System.out.println(company);
	}
	public void printCompany2(){
		System.out.println(company);
	}
	public static void main(String[] args) {
		StaticBlock sb = new StaticBlock();
	}

}
