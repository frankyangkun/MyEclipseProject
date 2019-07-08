package designmode.factory.factorymethod;

public class Client {
	public static void main(String[] args) {
		Car c1 = new AudiFactory().createCar();//通过Audi工厂创建
		Car c2 = new BydFactory().createCar();//通过Byd工厂创建
		c1.run();
		c2.run();
	}
}
