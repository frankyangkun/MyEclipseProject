package file;
/**
 * 遍历所有枚举值
 * @author yang
 *
 */
public class TestEnum2 {

	public static void main(String[] args) {
		for (Color c: Color.values()){
			System.out.println("find value:" + c);
		}
	}
}
enum Color {

	Red,Green,Blue;
	private static int number = Color.values().length;

	public static Color getRandomColor() {
		long random = System.currentTimeMillis() % number;

		switch ((int) random) {

		case 0:
			return Color.Red;
		case 1:
			return Color.Green;
		case 2:
			return Color.Blue;
		default:
			return Color.Red;
		}
	}
}