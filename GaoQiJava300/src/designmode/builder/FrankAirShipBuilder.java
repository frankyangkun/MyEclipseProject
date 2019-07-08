package designmode.builder;

/**
 * 宇宙飞船建造者
 * @author yang
 */
public class FrankAirShipBuilder implements AirShipBuilder{
//一般以Builder结尾的都是用到了建造者模式，比如StringBuilder，还有XML解析中，JDOM库的类：DomBuilder，SaxBuilder

	@Override
	public Engine builderEngine() {
		System.out.println("构建Frank牌发动机");
		return new Engine("Frank牌发动机!");//也可以通过发动机工厂来获得对象，和工厂模式结合起来，或者单例模式结合
	}
	@Override
	public OrbitalModule builderOrbitalModule() {
		System.out.println("构建Frank牌轨道舱");
		return new OrbitalModule("Frank牌轨道舱!");
	}
	@Override
	public EscapeTower builderEscapeTower() {
		System.out.println("构建Frank牌逃逸塔");
		return new EscapeTower("Frank牌逃逸塔!");
	}
}