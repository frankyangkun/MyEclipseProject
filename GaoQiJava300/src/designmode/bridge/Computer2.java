package designmode.bridge;
/**
 * 电脑类型的维度
 * @author yang
 */
public class Computer2 {
	protected Brand brand;
	//去持有brand对象的引用，不能用private，要让子类使用它，所以是protected
	public Computer2(Brand brand) {
		this.brand = brand;
	}
	public void sale(){
		brand.sale();//调用brand的sale方法
	}
}
class Desktop2 extends Computer2{
	public Desktop2(Brand brand) {
		super(brand);
	}
	@Override
	public void sale() {
		super.sale();
		System.out.println("销售台式机");
	}
}
class Laptop2 extends Computer2{
	public Laptop2(Brand brand) {
		super(brand);
	}
	@Override
	public void sale() {
		super.sale();
		System.out.println("销售笔记本");
	}
}