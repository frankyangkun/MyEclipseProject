package designmode.adapter;
/**
 * 适配器(类适配器方式)
 * （相当于例子中的USB和ps/2的转接器）
 * @author yang
 */
public class Adapter extends Adaptee implements Target{

	@Override
	public void handleReq() {
		super.request();
	}
}
