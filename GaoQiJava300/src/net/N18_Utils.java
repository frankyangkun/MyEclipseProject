package net;

import java.io.Closeable;

/**
 * 工具类
 * 释放资源
 * @author yang
 *
 */
public class N18_Utils {
	public static void close(Closeable... targets){//可变参数，io和socket都实现了Cloable接口
		for (Closeable target : targets) {
			try{
				if(null!=target){
					target.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
