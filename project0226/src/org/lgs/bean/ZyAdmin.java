/**
 * 
 */
package org.lgs.bean;

import java.util.Date;

/**
 * @FileName ZyAdmin.java
 * @TODO 
 * @Package org.lgs.bean
 * @Date 2020年2月26日
 * @Time 上午10:22:45
 * @author 刘国升
 */
public class ZyAdmin {
	// 注意：创建属性需要和字段相同，数据库字段如果有下划线那么属性的后面的单词首字母大写，例如：admin_ctime -> adminCtime
	// 注意：如果数据库是日期格式date类型，那么属性的类型必须是Date，导入util包
	private int zaid;
	private String username;
	private String password;
	private Date adminCtime;
	private int adminState;
	private int adminSex;
	private String adminTel;
	public ZyAdmin(int zaid, String username, String password, Date adminCtime, int adminState, int adminSex,
			String adminTel) {
		super();
		this.zaid = zaid;
		this.username = username;
		this.password = password;
		this.adminCtime = adminCtime;
		this.adminState = adminState;
		this.adminSex = adminSex;
		this.adminTel = adminTel;
	}
	public ZyAdmin() {
		super();
	}
	public int getZaid() {
		return zaid;
	}
	public void setZaid(int zaid) {
		this.zaid = zaid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getAdminCtime() {
		return adminCtime;
	}
	public void setAdminCtime(Date adminCtime) {
		this.adminCtime = adminCtime;
	}
	public int getAdminState() {
		return adminState;
	}
	public void setAdminState(int adminState) {
		this.adminState = adminState;
	}
	public int getAdminSex() {
		return adminSex;
	}
	public void setAdminSex(int adminSex) {
		this.adminSex = adminSex;
	}
	public String getAdminTel() {
		return adminTel;
	}
	public void setAdminTel(String adminTel) {
		this.adminTel = adminTel;
	}
	
}
