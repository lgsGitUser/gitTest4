/**
 * 
 */
package org.lgs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lgs.bean.JsonMessage;
import org.lgs.bean.ZyAdmin;
import org.lgs.service.ZyAdminServiceImpl;
import org.lgs.util.ServiceFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @FileName AdminLoginServlet.java
 * @TODO 
 * @Package org.lgs.servlet
 * @Date 2020年2月28日
 * @Time 上午9:47:43
 * @author 刘国升
 */
public class AdminLoginServlet extends HttpServlet {

	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// System.out.println("林方祥很帅，那是假的...");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		
		// 通过ajax提交的data里面的获取参数的key（条件）来获取参数
		String name = req.getParameter("zhanghu");
		String pwd = req.getParameter("mima");
		System.out.println(name + ":" + pwd);
		
		// 收到信息，开始做数据库查询
		ZyAdminServiceImpl impl = (ZyAdminServiceImpl) ServiceFactory.newInstance().getService("ZyAdminService");
		ZyAdmin admin = impl.login(name, pwd);
		
		if(admin != null) {
			// 1.整理需要返回的数据
			JsonMessage msg = new JsonMessage();
			msg.setId(1);
			msg.setMessage("登录成功");
			msg.setLocation("main.html");
			// 2.将对象转换成json数据字符串
			String json = JSONObject.toJSONString(msg);
			// 3.将字符串发送出去
			resp.getWriter().println(json);
		}else {
			// 1.整理需要返回的数据
			JsonMessage msg = new JsonMessage();
			msg.setId(0);
			msg.setMessage("登录失败，用户名或密码错误");
			// 2.将对象转换成json数据字符串
			String json = JSONObject.toJSONString(msg);
			// 3.将字符串发送出去
			resp.getWriter().println(json);
		}

		
	}
	
}
