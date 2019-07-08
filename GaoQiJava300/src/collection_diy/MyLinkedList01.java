package collection_diy;
/**
 * 自定义实现一个LinkedList(链表)，体会底层原理
 * 增加add方法
 * @author yang
 *
 */
public class MyLinkedList01 {
	private Node first;//前一个节点对象
	private Node last;//后一个节点对象
	private int size;
	
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
		MyLinkedList01 list = new MyLinkedList01();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list);
	}
}
