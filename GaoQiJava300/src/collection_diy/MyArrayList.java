package collection_diy;
/**
 * 自定义实现一个ArrayList，体会底层原理
 * @author yang
 *
 */
public class MyArrayList {
	private Object[] elementData;//核心数组，用来存储内容
	private int size;//数组元素个数
	
	private static final int DEFALT_CAPACITY = 10;
	
	public MyArrayList(){
		elementData = new Object[DEFALT_CAPACITY];
	}
	public MyArrayList(int capacity){
		elementData = new Object[capacity];
	}
	
	public void add(Object obj){
		elementData[size++] = obj;
	}
	//重写toString，用[a,b,c]形式打印
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
//		for (Object obj:elementData) {//foreach遍历数组，obj是临时变量
//			sb.append(obj+",");//StringBuilder，始终改变的是原来的字符串
//		}//[aa,bb,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,]
		//打印时不打印null，只打印数组中已有的
		for (int i = 0; i < size; i++) {
			sb.append(elementData[i]+",");
		}//[aa,bb,]
//		sb.append("]");//不用这种，否则打印结果是[aa,bb,]，会多一个逗号，使用【替换】setCharAt
		sb.setCharAt(sb.length()-1, ']');//只能用单引号，因为是单个字符
		//注意区分一下sb和elementData
		System.out.println(sb.length());//7,包含[aa,bb]所有字符长度
		
		return sb.toString();//重写的这个方法是String类型，而sb是StringBuilder类型，不能互转，因此需要调用toString()
	}
	public static void main(String[] args) {
		MyArrayList s1 = new MyArrayList(20);
		s1.add("aa");
		s1.add("bb");
		System.out.println(s1);//collection_diy.MyArrayList@7852e922
	}
}
