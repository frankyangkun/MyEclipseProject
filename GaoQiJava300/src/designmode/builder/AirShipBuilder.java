package designmode.builder;
/**
 * 装配者接口
 * @author yang
 */
public interface AirShipBuilder {
	Engine builderEngine();//构建发动机子组件
	OrbitalModule builderOrbitalModule();//构建轨道舱子组件
	EscapeTower builderEscapeTower();//构建逃逸塔子组件
}
