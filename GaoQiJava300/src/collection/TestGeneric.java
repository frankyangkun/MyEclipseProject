package collection;
/**
 * 测试泛型
 * @author yang
 *
 */
public class TestGeneric {

	public static void main(String[] args) {
		//标明实际类型，构造器后面直接写<>或<String>，<String>相当于实参
		MyCollection<String> mc = new MyCollection<String>();
		mc.set("frank", 0);
		String b = mc.get(0);
		System.out.println(b);
	}
}
//创建一个自定义容器
class MyCollection<E>{//<E>相当于形参
	Object[] objs = new Object[5];
	
	public void set(E obj,int index){
		objs[index] = obj;
	}
	public E get(int index){
		return (E)objs[index];//objs是Object类型，所以强转成E
	}
}