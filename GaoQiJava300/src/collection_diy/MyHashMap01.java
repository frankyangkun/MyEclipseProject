package collection_diy;
/**
 * 自定义实现HashMap，体会底层原理
 * 基本结构_put存储键值对
 * @author yang
 *
 */
public class MyHashMap01 {
	Node2[] table;//位桶数组（核心数组）
	int size;//存放键值对的个数
	
	public MyHashMap01() {
		table = new Node2[16];//长度一般定义成2的整数幂
	}
	public void put(Object key,Object value){
		//定义了新的节点对象
		Node2 newNode = new Node2();
		newNode.hash=myHash(key.hashCode(),table.length);//算出hash值
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;
		
		Node2 temp = table[newNode.hash];//把位桶数组对应hash值所在索引位置设为临时变量
		if(temp == null){//此处元素若为空，则直接将新节点放进去
			table[newNode.hash] = newNode;
		}else{
			//此处元素不为空，则遍历对应链表。。
			
		}
	}
	public int myHash(int v,int length){
		System.out.println("&hash in myHash:"+(v&(length-1)));//位运算，效率高，但要求是2的整数幂
		System.out.println("%hash in myHash:"+(v%(length-1)));//取模，效率低
		//&和%的作用一样，都是为了将对象尽量散列均匀存放到位桶数组，但两种方式的计算结果不一定相同
		return v&(length-1);//这里选择位运算，因为效率高
	}
	public static void main(String[] args) {
		MyHashMap01 m = new MyHashMap01();
		m.put(10, "a");
		m.put(20, "b");
		m.put(30, "c");
		System.out.println(m);
	}
}
