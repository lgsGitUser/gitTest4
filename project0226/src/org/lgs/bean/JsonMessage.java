/**
 * 
 */
package org.lgs.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName JsonMessage.java
 * @TODO 
 * @Package org.lgs.bean
 * @Date 2020年2月28日
 * @Time 上午10:34:46
 * @author 刘国升
 */
public class JsonMessage {

	private int id;
	private String message;
	private String location;
	private Map<String, Object> datas = new HashMap<String, Object>();
	public JsonMessage(int id, String message, String location, Map<String, Object> datas) {
		super();
		this.id = id;
		this.message = message;
		this.location = location;
		this.datas = datas;
	}
	public JsonMessage() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Map<String, Object> getDatas() {
		return datas;
	}
	public void setDatas(Map<String, Object> datas) {
		this.datas = datas;
	}
	
}
