package designmode.builder;
/**
 * 测试类
 * @author yang
 *
 */
public class Client {
	public static void main(String[] args) {
		AirShipDirector direcotr = new FrankAirShipDirector(new FrankAirShipBuilder());
		AirShip ship = direcotr.directAirShip();
		System.out.println("****"+ship.getEngine().getName());
		ship.launch();
	}
}
