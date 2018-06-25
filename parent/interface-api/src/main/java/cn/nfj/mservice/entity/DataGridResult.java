package cn.nfj.mservice.entity;

import java.io.Serializable;
import java.util.List;

public class DataGridResult implements Serializable{
	private long count;
	private List data;
	private Integer code;
	private String msg;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
