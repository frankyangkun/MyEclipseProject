package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试Collections工具类，不是Collection接口
 * @author yang
 *
 */
public class TestCollections {

	public static void main(String[] args) {
		List<String> list = new ArrayList();
		for (int i = 0; i < 10; i++) {
			list.add("frank"+i);
		}
		System.out.println(list);
		
		Collections.shuffle(list);//随机排序
		System.out.println(list);
		
		Collections.reverse(list);//逆序
		System.out.println(list);
		
		Collections.sort(list);//按递增排序，自定义类实现Comarable接口
		System.out.println(list);
		
		System.out.println(Collections.binarySearch(list, "frank4"));//二分查找
		
	}

}
