/**
 * 
 */
package org.lgs.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @FileName ConnUtil.java
 * @TODO 
 * @Package org.lgs.util
 * @Date 2020年2月26日
 * @Time 上午10:57:40
 * @author 刘国升
 */
public class ConnUtil {

	// 1.获取属性文件对象，用来读取config.properties的属性文件
	private static Properties prop = new Properties();
	// 2.通过静态代码块和属性文件对象，加载配置文件的信息
	// 静态代码块:当我们执行代码的时候，静态代码块会自动执行一次
	static {
		// 2.1.通过反射的机制，获取config.properties的属性文件的流
		InputStream inStream = ConnUtil.class.getClassLoader().getResourceAsStream("config.properties");
		// 2.2.开始加载数据
		try {
			prop.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 3.编写静态工具类，返回Connection
	public static Connection getConn() {
		try {
			// 3.1.判断你的驱动（jar文件）是否加载成功，如果没有加载就报错
			Class.forName(prop.getProperty("driver"));
			// 3.2.获取Connection对象,如果oracle有问题那么就报错
			Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), 
					prop.getProperty("password"));
			// 3.3.返回connection
			return conn;
		} catch (ClassNotFoundException e) { // 驱动没有配置好的错误
			e.printStackTrace();
		} catch (SQLException e) { // oracle没设置好的错误
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
