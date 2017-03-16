package cn.edu.scau.logistics.entity;

import java.util.List;

public class Series {
	private String name;
	private String type;
	private List<Integer> data;
	public static String TYPE_BAR = "bar";
	public Series(){
		
	}
	public Series(String name,String type,List<Integer> data){
		this.name = name;
		this.type = type;
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
	
	
}
