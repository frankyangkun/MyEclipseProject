package collection_diy;
/**
 * 自定义实现一个LinkedList(链表)，体会底层原理
 * 增加remove移除节点
 * @author yang
 *
 */
public class MyLinkedList03 {
	private Node first;//前一个节点对象
	private Node last;//最后一个节点对象
	private int size;
	
	public void remove(int index){
		Node temp = getNode(index);//获取node节点
		if(temp!=null){
			Node up = temp.previous;
			Node down = temp.next;
			
			if(up!=null){
				up.next = down;
			}
			if(down!=null){
				down.previous = up;
			}
			if(index == 0){//被删元素是第一个元素时
				first = down;
			}
			if(index == size-1){//被删元素是最后一个元素时
				last = up;
			}
			size --;
		}
	}
	//["a","b","c"]
	//如果要取c，实际上就是调用2次first，a.next.next，后面类推(a.next是b)
	public Object get(int index){//因为不是数组，所以get方法和之前的实现不同
		if(index<0 || index > size-1){
			throw new RuntimeException("索引数字不合法！"+index);
		}
		Node temp = getNode(index);//获取node节点
		return temp!=null?temp.element:null;//免得报空指针

	}
	//获取node节点方法，提高重用性
	public Node getNode(int index){
		Node temp = null;
		if(index<=(size>>1)){//小于索引的一半
			temp = first;//从前往后找  这一句不能写到for里面
			for (int i = 0; i < index; i++) {
				temp = temp.next;//多次调用next，如果传1，索引为1，也就是1次a.next，返回b
			}
		}else{
			temp = last;//从后往前找
			for (int i = size-1; i > index; i--) {
				temp = last;
				temp = temp.previous;
			}
		}
		return temp;
	}
	//[]
	//["a"]
	//["a","b"]
	//["a","b","c"]
	public void add(Object obj){
		Node node = new Node(obj);
		if(first == null){
//			node.previous = null;//首次调用前后都是空，可以不写
//			node.next = null;//首次调用前后都是空，可以不写
			first = node;
			last = node;
		}else{//第二个及后面的元素
			node.previous = last;//目前是["a"]，因此first和last都是a，当前的node是b，因此把a赋值给b的前节点
			node.next = null;//此时b的后节点没有内容
			
			last.next = node;//此时node是b，last还是a，因此需要把b赋值给a的后节点
			last = node;//此时node是b，此时的最后一个就应该是b了，因此b赋值给last
		}
		size++;
	}
	@Override
	public String toString(){
		//[a,b,c] first=a,last=c
		//a,b,c
		StringBuilder sb = new StringBuilder("[");
		Node temp = first;
		while(temp!=null){
			sb.append(temp.element+",");
//			System.out.println(temp.element);
			temp = temp.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	public static void main(String[] args) {
		MyLinkedList03 list = new MyLinkedList03();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		System.out.println(list.size);//add方法最后应该有size++，否则size是0
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.get(5));
		list.remove(0);
		System.out.println(list);
	}
}
