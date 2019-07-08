package file;
/**
 * 测试枚举
 * @author yang
 *
 */
public class TestEnum {

	public static void main(String[] args) {
//		System.out.println(Season.SPRING);
		Season s = Season.AUTUMN;
		
		switch(s){
		case SPRING:
			System.out.println("春天");
			break;
		case SUMMER:
			System.out.println("夏天");
			break;
		case AUTUMN:
			System.out.println("秋天");
			break;//如果没有break，会把冬天也打印出来
		case WINTER:
			System.out.println("冬天");
			break;
		}
	}
}

enum Season{
	SPRING,SUMMER,AUTUMN,WINTER
}
enum Week{
	周一,周二,周三,周四,周五,周六,周日
}