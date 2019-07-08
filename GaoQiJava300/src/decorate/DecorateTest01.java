package decorate;
/**
 * 装饰器测试 实现放大器对声音的放大功能（需建立在人的基础上，人和放大器都有发声的方法）
 * @author yang
 */
public class DecorateTest01 {
	public static void main(String[] args) {
		Person p = new Person();
		p.say();
		//装饰
		Amplifier a = new Amplifier(p);
		a.say();
	}
}
interface Voice {
	void say();
}
class Person implements Voice {
	// 属性
	private int voice = 10;

	@Override
	public void say() {
		System.out.println("people's voice:" + this.getVoice());
	}
	public int getVoice() {
		return voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}
}
class Amplifier implements Voice {
	// 加入对人的装饰
	private Person p;

	public Amplifier(Person p) {
		this.p = p;
	}
	@Override
	public void say() {
		System.out.println("Amplifier's voice:" + p.getVoice() * 100);
		System.out.println("noise..");
	}
}