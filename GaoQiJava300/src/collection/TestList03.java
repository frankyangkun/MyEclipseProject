package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList_索引和顺序相关方法
 * @author yang
 *
 */
public class TestList03 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		System.out.println(list);//[A, B, C, D]
		
		list.add(2,"frank");
		System.out.println(list);//[A, B, frank, C, D]
		
		list.remove(2);
		System.out.println(list);//[A, B, C, D]
		
		list.set(2, "frank");
		System.out.println(list);//替换[A, B, frank, D]
		System.out.println(list.get(2));//frank
		
		list.add("RR");
		list.add("TT");
		list.add("YY");
		list.add("B");
		System.out.println(list);
		System.out.println(list.indexOf("B"));//第一次出现的索引位置
		System.out.println(list.lastIndexOf("B"));//最后一次出现的索引位置
	}

}
