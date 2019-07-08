package collection_diy;
/**
 * 自定义实现HashMap，体会底层原理
 * 重写toString方法，方便查看kv信息
 * @author yang
 *
 */
public class MyHashMap03 {
	Node2[] table;//位桶数组（核心数组）
	int size;//存放键值对的个数
	
	public MyHashMap03() {
		table = new Node2[16];//长度一般定义成2的整数幂
	}
	public void put(Object key,Object value){
		//定义了新的节点对象
		Node2 newNode = new Node2();
		newNode.hash=myHash(key.hashCode(),table.length);//算出hash值
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;
		
		Node2 temp = table[newNode.hash];//把位桶数组对应hash值所在索引位置的内容设为临时变量（最开始是null）
		
		Node2 iterLast = null;//正在遍历的最后一个元素
		boolean keyRepeat = false;
		
		if(temp == null){//此处元素若为空，则直接将新节点放进去
			table[newNode.hash] = newNode;
			size++;
		}else{
			//此处元素不为空，则遍历对应链表。。
			while(temp!=null){//temp是位桶数组某索引位置的内容
				//判断key如果重复，则覆盖
				if(temp.key.equals(key)){//如果已有内容的key和调用put方法时传的key相同
					keyRepeat = true;
					temp.value = value;//只需要覆盖value即可，其他值（hash，key，next）保持不变
					
					break;//遇到key重复覆盖value后，就无需再想后面遍历了，必须有这步，否则遇到重复key无法退出while，卡死
				}else{
					//key不重复，则遍历下一个，直到最后元素.next为空
					iterLast = temp;//用iterLast保存最后一个元素，每次循环都假设temp是位桶数组某索引位置的链表中的最后一个元素，把它保存到iterLast
					temp = temp.next;//往后找，把temp的下一个赋值给它自己，直到最后一个，即temp.next为null时，此时temp==null,就退出while，代表到了最后一个。
					//而此时iterLast保存的就是temp==null之前的一次，是真正的最后一个元素
				}
			}
			if(!keyRepeat){//如果key没重复，才把newNode加到最后节点的后面
				iterLast.next = newNode;//此时iterLast是最后一个，所以iterLast.next是null，把新加元素noewNode指向新元素
				size++;
			}
		}
	}
	public static int myHash(int v,int length){
//		System.out.println("&hash in myHash:"+(v&(length-1)));//位运算，效率高，但要求是2的整数幂
//		System.out.println("%hash in myHash:"+(v%(length-1)));//取模，效率低
		//&和%的作用一样，都是为了将对象尽量散列均匀存放到位桶数组，但两种方式的计算结果不一定相同
		return v&(length-1);//这里选择位运算，因为效率高
	}
	@Override
	public String toString() {
		//{10:aa,20:bb}
		StringBuilder sb = new StringBuilder("{");
		for (int i = 0; i < table.length; i++) {//遍历位桶数组
			Node2 temp = table[i];
			while(temp!=null){//遍历链表
				sb.append(temp.key+":"+temp.value+",");
				temp = temp.next;
			}
		}
		sb.setCharAt(sb.length()-1,'}');
		return sb.toString();
	}
	public static void main(String[] args) {
		MyHashMap03 m = new MyHashMap03();
		m.put(10, "a");
		m.put(20, "b");
		m.put(30, "c");
		m.put(20, "ssss");
		m.put(53, "AAA");
		m.put(69, "BBB");
		m.put(85, "CCC");
		System.out.println(m);
//		for (int i = 10; i < 100; i++) {
//			System.out.println(i+"---"+myHash(i, 16));//找几个相同的key，比如53，69，85的hash值都是5
//		}
	}
}
