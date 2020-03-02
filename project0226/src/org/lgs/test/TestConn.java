/**
 * 
 */
package org.lgs.test;

import org.lgs.dao.ZyAdminDaoImpl;
import org.lgs.service.ZyAdminService;
import org.lgs.service.ZyAdminServiceImpl;
import org.lgs.util.DaoFactory;
import org.lgs.util.ServiceFactory;

/**
 * @FileName TestConn.java
 * @TODO 
 * @Package org.lgs.test
 * @Date 2020年2月26日
 * @Time 上午11:16:44
 * @author 刘国升
 */
public class TestConn {

	public static void main(String[] args) {
		/*ZyAdminDaoImpl impl = new ZyAdminDaoImpl();
		System.out.println(impl.queryAll());*/
		/*ZyAdminDaoImpl impl = (ZyAdminDaoImpl) DaoFactory.newInstance().getDao("ZyAdminDao");
		System.out.println(impl.queryAll());*/
		
		/*ZyAdminServiceImpl impl = new ZyAdminServiceImpl();
		System.out.println(impl.queryAllAdmins());*/
		ZyAdminServiceImpl impl = (ZyAdminServiceImpl) ServiceFactory.newInstance().getService("ZyAdminService");
		System.out.println(impl.queryAllAdmins());
	}
}
