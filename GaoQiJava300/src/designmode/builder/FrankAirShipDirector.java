package designmode.builder;

/**
 * 装配者的实现
 * @author yang
 */
public class FrankAirShipDirector implements AirShipDirector{
	private AirShipBuilder builder;//装配者肯定要调用构建者创建好的对象
	
	public FrankAirShipDirector(AirShipBuilder builder) {
		this.builder = builder;
	}
	@Override
	public AirShip directAirShip() {
		//构建子组件
		Engine e = builder.builderEngine();
		OrbitalModule o = builder.builderOrbitalModule();
		EscapeTower et = builder.builderEscapeTower();
		
		//组装子组件
		AirShip ship = new AirShip();
		ship.setEngine(e);
		ship.setEscapeTower(et);
		ship.setOrbitalModule(o);
		
		return ship;
	}
}
