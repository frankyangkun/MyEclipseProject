package collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试TreeMap的使用
 * @author yang
 *
 */
public class TestTreeMap {

	public static void main(String[] args) {
		Map<Integer,String> treemap1 = new TreeMap<>();
		treemap1.put(20, "aa");
		treemap1.put(3, "bb");
		treemap1.put(6, "cc");
		
		//按照key递增方式排序，hashmap打印是无序的
		for (Integer key:treemap1.keySet()) {//key会返回一个set集合，然后从set中将key依次取出来
			System.out.println(key+"----"+treemap1.get(key));
		}
		
		Map<Emp,String> treemap2 = new TreeMap<>();
		treemap2.put(new Emp(1001,"张三",20000),"很不错");
		treemap2.put(new Emp(5001,"李四",5000),"不行");
		treemap2.put(new Emp(3001,"王五",9000),"还行");
		treemap2.put(new Emp(4001,"赵六",5000),"不行");
		
		for (Emp key:treemap2.keySet()) {
			System.out.println(key+""+treemap2.get(key));
		}
	}
}
class Emp implements Comparable<Emp>{//和Emp做对比，所以泛型是Emp
	int id;
	String name;
	double salary;//比如想按照薪水来排序
	
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	@Override
		public String toString() {
			return "id:"+id+",name:"+name+",salary:"+salary;
		}

	@Override
	public int compareTo(Emp o) {//当前对象和指定的o对象进行排序（负数：小于，0：等于，正数：大于）
		if(this.salary>o.salary){//先按薪水排序
			return 1;
		}else if(this.salary<o.salary){
			return -1;
		}else{//如果薪水相同，继续按照id排序，id不会相同
			if(this.id>o.id){
				return 1;
			}else if(this.id<o.id){
				return -1;
			}else{
				return 0;
			}
		}
	}//这个方法可以用在很多地方，如果需要对自定义类进行排序，写法都大同小异
}