package designmode.factory.abstractFactory;
/**
 * 高端汽车工厂
 * @author yang
 */
public class LuxuryCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		return new LuxuryEngine();
	}
	
	@Override
	public Seat createSeat() {
		return new LuxurySeat();
	}
	
	@Override
	public Tyre createTyre() {
		return new LuxuryTyre();
	}
}
