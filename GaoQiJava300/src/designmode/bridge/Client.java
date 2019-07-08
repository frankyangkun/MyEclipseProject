package designmode.bridge;

public class Client {
	public static void main(String[] args) {
		//销售联想笔记本
		//Lenovo是Brand中的品牌维度类，Laptop2是Computer2中的类型维度类
		Computer2 c = new Laptop2(new Lenovo());
		c.sale();
		//销售戴尔电脑
		Computer2 c2 = new Desktop2(new Dell());//戴尔台式机
		c2.sale();
		Computer2 c3 = new Laptop2(new Dell());//戴尔笔记本
		c3.sale();
	}
}
