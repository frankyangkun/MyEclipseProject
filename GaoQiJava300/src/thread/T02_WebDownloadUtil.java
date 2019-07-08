package thread;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;

/**
 * 多线程下载图片
 * @author yang
 *
 */
public class T02_WebDownloadUtil {

	/**
	 * 下载图片
	 * @param url
	 * @param name
	 */
	public void download(String url,String name){
		try {
			FileUtils.copyURLToFile(new URL(url),new File(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("不合法的路径！");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("图片下载失败！");
		}
	}
}
