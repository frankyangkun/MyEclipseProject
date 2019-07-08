package designmode.bridge;


public interface Computer {
	void sale();
}
class Desktop implements Computer{
	@Override
	public void sale() {
		System.out.println("销售台式机");
	}
}
class Laptop implements Computer{
	@Override
	public void sale() {
		System.out.println("销售笔记本");
	}
}
class Pad implements Computer{
	@Override
	public void sale() {
		System.out.println("销售平板电脑");
	}
}

class LenovoDesktop extends Desktop{
	public void sale() {
		System.out.println("销售联想笔记本");
	}
}
class LenovoTop extends Desktop{
	public void sale() {
		System.out.println("销售联想平板电脑");
	}
}
class LenovoPad extends Pad{
	public void sale() {
		System.out.println("销售联想笔记本");
	}
}

class ShenzhouDesktop extends Desktop{
	public void sale() {
		System.out.println("销售神州笔记本");
	}
}
class ShenzhouTop extends Desktop{
	public void sale() {
		System.out.println("销售神州平板电脑");
	}
}
class ShenzhouPad extends Pad{
	public void sale() {
		System.out.println("销售神州笔记本");
	}
}