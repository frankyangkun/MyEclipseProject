package designmode.adapter;
/**
 * 被适配的类
 * （相当于例子中的ps/2键盘）
 * @author yang
 */
public class Adaptee {
	public void request(){
		System.out.println("可以完成客户请求需要的功能");
	}
}
