package designmode.composite;

public class Client {
	public static void main(String[] args) {
		AbstractFile f2,f3,f4,f5;
		Folder f1 = new Folder("我的收藏");
		f2 = new ImageFile("myPic.jpg");
		f3 = new TextFile("Hello.txt");
		f1.add(f2);
		f1.add(f3);
//		f2.killVirus();//无论任何格式，都是统一的处理方式
//		f1.killVirus();//无论任何格式，都是统一的处理方式
		
		Folder f11 = new Folder("movie1");
		f4 = new VideoFile("钢铁侠1");
		f5 = new VideoFile("钢铁侠2");
		f11.add(f4);
		f11.add(f5);
		f1.add(f11);
		f1.killVirus();
	}
}
