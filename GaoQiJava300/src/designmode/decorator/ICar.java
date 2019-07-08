package designmode.decorator;
/**
 * Component抽象构建角色
 * @author yang
 */
public interface ICar {
	void move();
}
/**
 * ConcreteComponent具体构建角色(真实对象)
 * @author yang
 */
class Car implements ICar{
	@Override
	public void move() {
		System.out.println("陆地上跑！");
	}
}
/**
 * Decorator装饰角色
 * @author yang
 */
class SuperCar implements ICar{
	protected ICar car;//持有真实对象的引用 要让子类调用，所以要用protected，不是private
	public SuperCar(ICar car) {
		this.car = car;
	}
	@Override
	public void move() {
		car.move();
	}
}
/**
 * ConcreteDecorator具体装饰角色
 * @author yang
 */
class FlyCar extends SuperCar{
	public FlyCar(ICar car) {
		super(car);
	}
	public void fly(){
		System.out.println("天上飞！");//新增方法
	}
	@Override
	public void move() {
		super.move();
		fly();
	}
}	
/**
 * ConcreteDecorator具体装饰角色
 * @author yang
 */
class WaterCar extends SuperCar{
	public WaterCar(ICar car) {
		super(car);
	}
	public void swim(){
		System.out.println("水上游！");//新增方法
	}
	@Override
	public void move() {
		super.move();
		swim();
	}
}
/**
 * ConcreteDecorator具体装饰角色
 * @author yang
 */
class AiCar extends SuperCar{
	public AiCar(ICar car) {
		super(car);
	}
	public void autoMove(){
		System.out.println("自动跑！");//新增方法
	}
	@Override
	public void move() {
		super.move();
		autoMove();
	}
}	
