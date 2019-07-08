package base;
//带标签的continue
public class TagContinue {

	public static void main(String[] args) {
		//打印101-150之前的所有质数（只能被1和本身整除）
		outer:for(int i=101;i<150;i++){
			for(int j=2;j<i/2;j++){
			//1都能被整除，所以从2开始，大于i/2意味着i/j小于1，除不尽i%j就不会为0，肯定不为质数，因此不需要算另外一半
				if(i%j == 0){
					continue outer;
				}
			}
			System.out.println(i+" ");
		}
	}
}
