/**
 * 
 */
package org.lgs.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.lgs.bean.ZyAdmin;
import org.lgs.dao.ZyAdminDaoImpl;
import org.lgs.util.ConnUtil;
import org.lgs.util.DaoFactory;

/**
 * @FileName ZyAdminServiceImpl.java
 * @TODO 
 * @Package org.lgs.service
 * @Date 2020年2月27日
 * @Time 上午9:07:53
 * @author 刘国升
 */
public class ZyAdminServiceImpl implements ZyAdminService {

	@Override
	public List<ZyAdmin> queryAllAdmins() {
		Connection conn = ConnUtil.getConn(); // 这里的Connection = 林方祥
		try {
			// 自动提交关闭，相当于不让林方祥回家交差，如果不写这句话相当于林方祥买了酱油就跑了，不管醋有没有卖
			conn.setAutoCommit(false); 
			ZyAdminDaoImpl impl = (ZyAdminDaoImpl) DaoFactory.newInstance().getDao("ZyAdminDao");
			List<ZyAdmin> admins = impl.queryAll(conn);
			conn.commit(); // 确定事情完成，可以回家了
			return admins;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.lgs.service.ZyAdminService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public ZyAdmin login(String name, String pwd) {
		// TODO Auto-generated method stub
		Connection conn = ConnUtil.getConn(); // 这里的Connection = 林方祥
		try {
			// 自动提交关闭，相当于不让林方祥回家交差，如果不写这句话相当于林方祥买了酱油就跑了，不管醋有没有卖
			conn.setAutoCommit(false); 
			ZyAdminDaoImpl impl = (ZyAdminDaoImpl) DaoFactory.newInstance().getDao("ZyAdminDao");
			ZyAdmin admin = impl.queryAdmin(conn, name, pwd);
			conn.commit(); // 确定事情完成，可以回家了
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
