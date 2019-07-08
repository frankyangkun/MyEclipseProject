package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 测试Collection接口中的方法
 * @author yang
 *
 */
public class TestList {
	public static void main(String[] args) {
		Collection c = new ArrayList();//ArrayList是List接口的实现类，而List接口是Collection接口的子接口
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		
		c.add("frank1");
		c.add("frank2");
		System.out.println(c);//[frank1, frank2],调用的toString方法
		System.out.println(c.size());
		System.out.println(c.contains("frank1"));//true
		
		Object[] objs = c.toArray();//把c转成数组对象
		System.out.println(objs);//[Ljava.lang.Object;@7852e922
		
		c.remove("frank1");//remove是移除容器c中的对象地址，原对象还在
		System.out.println(c);//[frank2]
		System.out.println(c.contains("frank1"));//false
		
		c.clear();//移除容器中所有对象
		System.out.println(c.size());//0
	}

}
