package designmode.composite;

import java.util.ArrayList;
import java.util.List;
//组合模式
//抽象构建，相当于Component.java中的Component接口
public interface AbstractFile {
	void killVirus();//杀毒
}

class ImageFile implements AbstractFile{//ImageFile是叶子组件
	private String name;
	public ImageFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("图像文件"+name+"，进行查杀");
	}
}
class TextFile implements AbstractFile{//TextFile是叶子组件
	private String name;
	public TextFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("文本文件"+name+"，进行查杀");
	}
}
class VideoFile implements AbstractFile{//VideoFile是叶子组件
	private String name;
	public VideoFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("视频文件"+name+"，进行查杀");
	}
}
class Folder implements AbstractFile{//Folder文件夹是容器组件，因为下面还有子组件
	private String name;
	//定义容器，用来存放本容器构建下的子节点
	private List<AbstractFile> list = new ArrayList<>();
	
	public Folder(String name) {
		this.name = name;
	}
	public void add(AbstractFile file){//add里面加的是抽象组件，也就是AbstractFile
		list.add(file);
	}
	public void remove(AbstractFile file){
		list.remove(file);
	}
	public AbstractFile getChild(int index){
		return list.get(index);
	}
	@Override
	public void killVirus() {
		System.out.println("文件夹"+name+"，进行查杀");
		for (AbstractFile file:list) {
			file.killVirus();//如果发现子节点依然是文件夹，还是跑到Folder类执行，是天然的递归
			System.out.println();
		}
	}
}