package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList_操作多个List_并集和交集
 * @author yang
 *
 */
public class TestList02 {

	public static void main(String[] args) {
		List<String> list01 = new ArrayList<>();
		list01.add("1");
		list01.add("2");
		list01.add("3");
		System.out.println("list01:"+list01);
		
		List<String> list02 = new ArrayList<>();
		list02.add("a");
		list02.add("b");
		list02.add("c");
		list01.addAll(list02);
		System.out.println("list01:"+list01);
		
//		list01.removeAll(list02);//删除共有的
//		System.out.println("list01:"+list01);
		
		System.out.println("list01:"+list01);
		System.out.println("list02:"+list02);
		list01.retainAll(list02);//保留共有的
		System.out.println("list01:"+list01);
	}
}
