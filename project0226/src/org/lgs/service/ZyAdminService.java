/**
 * 
 */
package org.lgs.service;

import java.util.List;

import org.lgs.bean.ZyAdmin;

/**
 * @FileName ZyAdminService.java
 * @TODO 
 * @Package org.lgs.service
 * @Date 2020年2月27日
 * @Time 上午9:07:37
 * @author 刘国升
 */
public interface ZyAdminService {

	List<ZyAdmin> queryAllAdmins();
	
	ZyAdmin login(String name, String pwd);
}
