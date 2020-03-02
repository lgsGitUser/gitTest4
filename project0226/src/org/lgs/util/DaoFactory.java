/**
 * 
 */
package org.lgs.util;

import java.util.HashMap;
import java.util.Map;

import org.lgs.dao.ZyAdminDaoImpl;

/**
 * @FileName DaoFactory.java
 * @TODO 
 * @Package org.lgs.util
 * @Date 2020年2月26日
 * @Time 上午11:21:29
 * @author 刘国升
 */
public class DaoFactory {
	// 1.首先工厂自己需要单例
	private static DaoFactory f;
	private DaoFactory() {}
	public static DaoFactory newInstance() {
		if(f == null) {
			f = new DaoFactory();
		}
		return f;
	}
	
	
	// 这里的工厂主要是创建dao，所以我写一个map用来保存我创建出来的dao
	// 1.创建一个map，静态，key是String类型，value是object类型
	private static Map<String, Object> map = new HashMap<String, Object>();
	// 2.写一个静态代码块，将初始化的dao对象全部丢到map中
	static {
		ZyAdminDaoImpl impl1 = new ZyAdminDaoImpl();
		map.put("ZyAdminDao", impl1);
	}
	// 3.创建一个方法传入对应的key，返回对应dao对象
	public Object getDao(String key) {
		return map.get(key);
	}
	// 相当于工厂只有一个，当调用getDao时，只要给了正确的key就可以得到对应的dao对象
	
}
