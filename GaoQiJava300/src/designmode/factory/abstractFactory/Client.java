package designmode.factory.abstractFactory;

public class Client {
	public static void main(String[] args) {
		CarFactory cf = new LuxuryCarFactory();
		Engine e = cf.createEngine();
		e.run();
		e.start();
	}
}
