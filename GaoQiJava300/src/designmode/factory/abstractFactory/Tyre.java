package designmode.factory.abstractFactory;

public interface Tyre {
	void revolve();
}
class LuxuryTyre implements Tyre{
	@Override
	public void revolve() {
		System.out.println("旋转磨损慢");	
	}
}
class LowTyre implements Tyre{
	@Override
	public void revolve() {
		System.out.println("旋转磨损快");	
	}
}