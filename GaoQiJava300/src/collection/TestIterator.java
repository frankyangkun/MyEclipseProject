package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 使用迭代器遍历List，Set，Map
 * @author yang
 *
 */
public class TestIterator {

	public static void main(String[] args) {
		testIteratorList();
		System.out.println("********");
		testIteratorSet();
		System.out.println("********");
		testIteratorMap();
	}
	public static void testIteratorList(){
		List<String> list = new ArrayList();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		//使用迭代器遍历List
		//list.iterator()获得迭代器,最后不需要++，在下面使用next就行了
		for(Iterator<String> iter = list.iterator();iter.hasNext();){//获得迭代器，注意不是冒号，是等号，不是foreach
			String temp = iter.next();//iter.next();有返回值，必须接收
			System.out.println(temp);
		}
	}
	public static void testIteratorSet(){
		Set<String> set = new HashSet();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		
		//使用迭代器遍历Set
		//list.iterator()获得迭代器,最后不需要++，在下面使用next就行了
		for(Iterator<String> iter = set.iterator();iter.hasNext();){//获得迭代器，注意不是冒号，是等号，不是foreach
			String temp = iter.next();//iter.next();有返回值，必须接收
			System.out.println(temp);
		}
	}
	
	public static void testIteratorMap(){
		Map<Integer,String> map1 = new HashMap<>();
		map1.put(1, "aa");
		map1.put(2, "bb");
		map1.put(3, "cc");
		
		//使用迭代器遍历Map（方法一）
		Set<Entry<Integer,String>> ss = map1.entrySet();//Entry<Integer,String>就是获得的键值对
		for(Iterator<Entry<Integer,String>> iter = ss.iterator();iter.hasNext();){
			Entry<Integer,String> temp = iter.next();//iter.next();有返回值，必须接收
			System.out.println(temp);//直接打印
			System.out.println("key:"+temp.getKey()+",value:"+temp.getValue());//分别打印
		}
		
		//使用迭代器遍历Map（方法二）
		Set<Integer> keySet = map1.keySet();//获取所有key的集合
		for(Iterator<Integer> iter=keySet.iterator();iter.hasNext();){//获得迭代器，注意不是冒号，是等号，不是foreach
			Integer key = iter.next();//获得的是key集合中的每个key，所以是Integer类型
			System.out.println("&&key:"+key+",&&value:"+map1.get(key));//通过map对象根据key获取value	
		}
	}	
}
