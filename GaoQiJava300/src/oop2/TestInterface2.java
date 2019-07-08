package oop2;
//测试接口多继承
public class TestInterface2 {

}

interface A{
	void testa();
}
interface B{
	void testb();
}

interface C extends A,B{
	void testc();
}
class Test implements C{

	@Override
	public void testa() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void testb() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void testc() {
		// TODO Auto-generated method stub
		
	}
	
}