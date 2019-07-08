package designmode.factory.simplefactory;
/**
 * 简单工厂类2
 * @author yang
 */
public class CarFactory2 {
	public static Car createAudi(){
		return new Audi();
	}
	public static Car createByd(){
		return new Byd();
	}
}
