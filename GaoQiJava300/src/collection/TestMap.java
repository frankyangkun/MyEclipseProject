package collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<Integer,String>	m1 = new HashMap<>();//KV值任意类型都行
		m1.put(1, "one");
		m1.put(2, "two");
		m1.put(3,"three");
		
		System.out.println(m1.get(1));
		System.out.println(m1.containsKey(2));
		System.out.println(m1.containsValue("frank"));
		System.out.println(m1.size());
		System.out.println(m1.isEmpty());
		
		Map<Integer,String>	m2 = new HashMap<>();
		m2.put(4, "四");
		m2.put(5, "五");
		
		m1.putAll(m2);
		System.out.println(m1);//{1=one, 2=two, 3=three, 4=四, 5=五}
		
		//map中键不能重复，如果重复（根据equals方法判断），新的覆盖旧的
		m1.put(3, "三");//调用Integer的equals方法判断是否重复
		System.out.println(m1);//{1=one, 2=two, 3=三, 4=四, 5=五}
		
	}

}
