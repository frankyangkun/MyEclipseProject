package classloader;
/**
 * 测试简单的加密解密（取反）操作
 * @author yang
 *
 */
public class Demo04 {
	public static void main(String[] args) throws Exception {
		//测试取反操作
//		int a = 3;//00000011
//		System.out.println(Integer.toBinaryString(a^0xff));//异或取反11111100（和11111111相比，相同为0，不同为1）
		
		//加密后的class文件，正常的类加载器无法加载，报java.lang.ClassFormatError:
//		FileSystemClassLoader loader = new FileSystemClassLoader("/Users/yang/Downloads/test/temp");
//		Class<?> c = loader.loadClass("hello");
		
		DecryptClassLoader loader2 = new DecryptClassLoader("/Users/yang/Downloads/test/temp");
		Class<?> c2 = loader2.loadClass("hello");
		System.out.println(c2);
	}
}
