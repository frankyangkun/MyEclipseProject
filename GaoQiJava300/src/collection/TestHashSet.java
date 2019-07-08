package collection;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试HashSet
 * @author yang
 *
 */
public class TestHashSet {

	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		set1.add("a");
		set1.add("b");
		set1.add("a");
		set1.remove("b");
		System.out.println(set1);//不可重复，只有[a]
		
		Set<String> set2 = new HashSet<>();
		set2.add("frank");
		set1.addAll(set2);
		System.out.println(set1);//[frank, a, b]	
	}
}
