/**
 * 
 */
package org.lgs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.lgs.bean.ZyAdmin;
import org.lgs.util.ConnUtil;

/**
 * @FileName ZyAdminDaoImpl.java
 * @TODO 
 * @Package org.lgs.dao
 * @Date 2020年2月26日
 * @Time 上午10:55:42
 * @author 刘国升
 */
public class ZyAdminDaoImpl implements ZyAdminDao {

	@Override
	public List<ZyAdmin> queryAll(Connection conn) {
		// 1.编写sql
		String sql = "SELECT * FROM ZY_ADMIN";
		// 2.获取Connection
		// Connection conn = ConnUtil.getConn();
		try {
			// 3.获取预编译对象（用来设置参数以及判断你的sql语句是否有误）
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.开始执行搜索(返回结果集信息，所有的查询数据都在ResultSet对象中)
			ResultSet set = ps.executeQuery();
			// 5.从ResultSet中得到数据保存到ZyAdmin集合中
			// 5.1.先创建一个集合
			List<ZyAdmin> admins = new ArrayList<ZyAdmin>();
			// 5.2.遍历找到每一行的数据，并保存到5.1创建好的集合中
			while(set.next()) {
				int zaid = set.getInt("ZAID");
				String username = set.getString("USERNAME");
				String password = set.getString("PASSWORD");
				Date adminCtime = set.getDate("ADMIN_CTIME");
				int adminState = set.getInt("ADMIN_STATE");
				int adminSex = set.getInt("ADMIN_SEX");
				String adminTel = set.getString("ADMIN_TEL");
				
				ZyAdmin admin = new ZyAdmin(zaid, username, password, adminCtime, adminState, adminSex, adminTel);
				admins.add(admin);
			}
			// 最后将集合返回
			return admins;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.lgs.dao.ZyAdminDao#queryAdmin(java.sql.Connection, java.lang.String, java.lang.String)
	 */
	@Override
	public ZyAdmin queryAdmin(Connection conn, String name, String pwd) {
		String sql = "SELECT * FROM ZY_ADMIN WHERE USERNAME = ? AND PASSWORD = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ResultSet set = ps.executeQuery();
			if(set.next()) {
				int zaid = set.getInt("ZAID");
				String username = set.getString("USERNAME");
				String password = set.getString("PASSWORD");
				Date adminCtime = set.getDate("ADMIN_CTIME");
				int adminState = set.getInt("ADMIN_STATE");
				int adminSex = set.getInt("ADMIN_SEX");
				String adminTel = set.getString("ADMIN_TEL");
				
				ZyAdmin admin = new ZyAdmin(zaid, username, password, adminCtime, adminState, adminSex, adminTel);
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
