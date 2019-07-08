package designmode.factory.simplefactory;
/**
 * 测试在没有工厂模式的情况下
 * @author yang
 */
public class Client02 {//调用者
	public static void main(String[] args) {
		Car c1 = CarFactory.createCar("奥迪");
		Car c2 = CarFactory.createCar("比亚迪");
		
		c1.run();
		c2.run();
	}
}