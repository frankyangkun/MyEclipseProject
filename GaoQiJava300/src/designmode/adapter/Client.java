package designmode.adapter;
/**
 * 客户端类
 * （相当于例子中的笔记本电脑，只有USB接口）
 * @author yang
 */
public class Client {
	public void test1(Target t){
		t.handleReq();
	}
	public static void main(String[] args) {
		Client c = new Client();//相当于笔记本电脑
		Adaptee a = new Adaptee();//相当于例子中的ps/2键盘
		
//		Target t = new Adapter();//类适配器方式，相当于例子中的USB和ps/2的转接器
//		c.test1(t);
		Target t = new Adapter2(a);//对象适配器方式
		c.test1(t);
	}
}