package com.let.pojo;

import java.io.Serializable;
import java.util.Date;

//实现序列化,转化成二进制流在远程传输数据,持久化(写磁盘)
public class BasePojo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Date created;
	private Date Updated;
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return Updated;
	}
	public void setUpdated(Date updated) {
		Updated = updated;
	}
	
}
