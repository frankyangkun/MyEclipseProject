package oop;
//测试参数传值机制
public class ParamTrans {
	int id;
	String name;
	String pwd;
	
	public ParamTrans(int id,String name){
		this.id = id;
		this.name = name;
	}
	public void testParamTrans(ParamTrans p){//被调用后对象p变为了对象pt的地址
		p.name = "frank2";
	}
	
	public void testParamTrans2(ParamTrans p){
		p = new ParamTrans(102, "frank3");
		System.out.println("***new***"+p.name);//新对象会改变值，但原有对象的值不受影响
	}
	public static void main(String[] args) {
		ParamTrans pt = new ParamTrans(101, "frank");//此时name是frank
		pt.testParamTrans(pt);//对象pt的地址被传给了testParamTrans方法
		System.out.println(pt.name);//此时name是frank2
		
		pt.testParamTrans2(pt);//新产生的对象值会变
		System.out.println(pt.name);//此时name是frank2，老对象值不变
	}
}//因此调用的时候把对象地址传过去了，pt和p都指向了同一个内存地址，所以pt.name值会变。
