package collection;

import java.util.TreeSet;

/**
 * 测试TreeSet，及Comparable接口
 * @author yang
 *
 */
public class TestTreeSet {
	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(44);
		ts.add(11);
		ts.add(33);
		System.out.println(ts);
		for(Integer temp:ts){
			System.out.println(temp);
		}

		TreeSet<Emp2> ts2 = new TreeSet<>();
		ts2.add(new Emp2(1001,"张三",20000));
		ts2.add(new Emp2(5001,"李四",5000));
		ts2.add(new Emp2(3001,"王五",9000));
		ts2.add(new Emp2(4001,"赵六",5000));
		
		System.out.println(ts2);//直接打印
		for(Object o:ts2){
			System.out.println(o);//按顺序打印 
		}
	}
}
//下面这个类是从TreeMap例子copy的
class Emp2 implements Comparable<Emp2>{//和Emp做对比，所以泛型是Emp
	int id;
	String name;
	double salary;//比如想按照薪水来排序
	
	public Emp2(int id, String name, double salary) {
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
	public int compareTo(Emp2 o) {//当前对象和指定的o对象进行排序（负数：小于，0：等于，正数：大于）
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