package designmode.decorator;

public class Client {
	public static void main(String[] args) {
		Car car = new Car();
		car.move();
		System.out.println("新增功能----------");
		ICar car2 = new FlyCar(car);
//		FlyCar car2 = new FlyCar(car);//这样也可以
		car2.move();
		System.out.println("新增功能----------");
		ICar car3 = new WaterCar(car);
//		WaterCar car3 =  new WaterCar(car);//这样也可以
		car3.move();
		System.out.println("新增功能----------");
		ICar car4 = new AiCar(car);
//		AiCar car4 = new AiCar(car);//这样也可以
		car4.move();
		
		System.out.println("新增多个功能----------");
		ICar car5 = new AiCar(car3);
		car5.move();//因为重写的move方法会先调用super.move();再调用新增方法，所以打印出来是多个结果
		//所以可以简写如下：
		System.out.println("***全功能***");
		AiCar car6 = new AiCar(new WaterCar(new FlyCar(new Car())));
		car6.move();//这样就具备所有功能了，并且可以随意组合，看上面的写法，跟IO里的装饰流一模一样
	}
}
