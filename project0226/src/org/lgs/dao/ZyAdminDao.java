/**
 * 
 */
package org.lgs.dao;

import java.sql.Connection;
import java.util.List;

import org.lgs.bean.ZyAdmin;

/**
 * @FileName ZyAdminDao.java
 * @TODO 
 * @Package org.lgs.dao
 * @Date 2020年2月26日
 * @Time 上午10:54:55
 * @author 刘国升
 */
public interface ZyAdminDao {

	/**
	 * 查询所有用户数据
	 * @return
	 */
	List<ZyAdmin> queryAll(Connection conn);
	
	/**
	 * 登录查询
	 * @param conn
	 * @param name
	 * @param pwd
	 * @return
	 */
	ZyAdmin queryAdmin(Connection conn, String name, String pwd);
}
