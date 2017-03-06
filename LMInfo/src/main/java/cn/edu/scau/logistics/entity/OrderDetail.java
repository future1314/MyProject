package cn.edu.scau.logistics.entity;

public class OrderDetail {
	private int ordertableDetailId;
	private int ordertablerId;
	private String productId;
	private String productName;
	private String productCategory;
	private String productWeight;
	private String productVolume;
	private String productNum;
	private String freight;
	private String income;
	private String other;
	
	public int getOrdertableDetailId() {
		return ordertableDetailId;
	}
	public void setOrdertableDetailId(int ordertableDetailId) {
		this.ordertableDetailId = ordertableDetailId;
	}
	public int getOrdertablerId() {
		return ordertablerId;
	}
	public void setOrdertablerId(int ordertablerId) {
		this.ordertablerId = ordertablerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(String productWeight) {
		this.productWeight = productWeight;
	}
	public String getProductVolume() {
		return productVolume;
	}
	public void setProductVolume(String productVolume) {
		this.productVolume = productVolume;
	}
	public String getProductNum() {
		return productNum;
	}
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	public String getFreight() {
		
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	
}
