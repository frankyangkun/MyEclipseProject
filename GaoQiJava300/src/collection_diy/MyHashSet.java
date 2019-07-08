package collection_diy;
import java.util.HashMap;
/**
 * 手动实现HashSet底层
 * @author yang
 *
 */
public class MyHashSet {
	HashMap map;
	private static final Object PRESENT = new Object();
	
	public MyHashSet() {
		map = new HashMap();
	}
	public void add(Object o){
		map.put(o,PRESENT);//每次都用都是PRESENT，不用重复创建
	}
	public int size(){
		return map.size();
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');//单引号双引号都可以
		for(Object key:map.keySet()){//遍历key,该方法返回map中所有key值的列表
			sb.append(key+",");
		}
		sb.setCharAt(sb.length()-1, ']');//注意不能写成双引号
		return sb.toString();
	}
	public static void main(String[] args) {
		MyHashSet set = new MyHashSet();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		System.out.println(set);
	}
}
