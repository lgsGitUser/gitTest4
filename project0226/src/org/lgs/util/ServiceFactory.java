/**
 * 
 */
package org.lgs.util;

import java.util.HashMap;
import java.util.Map;

import org.lgs.service.ZyAdminServiceImpl;

/**
 * @FileName Service.java
 * @TODO 
 * @Package org.lgs.util
 * @Date 2020年2月27日
 * @Time 上午9:49:42
 * @author 刘国升
 */
public class ServiceFactory {

	private static ServiceFactory f;
	private ServiceFactory() {
		
	}
	public static ServiceFactory newInstance() {
		if(f == null) {
			f = new ServiceFactory();
		}
		return f;
	}
	
	private static Map<String, Object> map = new HashMap<String, Object>();
	static {
		ZyAdminServiceImpl impl1 = new ZyAdminServiceImpl();
		map.put("ZyAdminService", impl1);
	}
	public Object getService(String key) {
		return map.get(key);
	}
}
