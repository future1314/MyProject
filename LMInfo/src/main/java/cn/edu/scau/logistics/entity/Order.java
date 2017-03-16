package cn.edu.scau.logistics.entity;

public class Order {
	private int ordertablerId;
	private int customerId;
	private String customerName;
	private String consignee;
	private String receivingTel;
	private String receivingAddress;
	private String sendTime;
	private String arriveTime;
	private String isSend;
	private String operatorName;
	private String ordersTime;
	private String tableState;
	public int getOrdertablerId() {
		return ordertablerId;
	}
	public void setOrdertablerId(int ordertablerId) {
		this.ordertablerId = ordertablerId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getReceivingTel() {
		return receivingTel;
	}
	public void setReceivingTel(String receivingTel) {
		this.receivingTel = receivingTel;
	}
	public String getReceivingAddress() {
		return receivingAddress;
	}
	public void setReceivingAddress(String receivingAddress) {
		this.receivingAddress = receivingAddress;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getIsSend() {
		return isSend;
	}
	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getOrdersTime() {
		return ordersTime;
	}
	public void setOrdersTime(String ordersTime) {
		this.ordersTime = ordersTime;
	}
	public String getTableState() {
		return tableState;
	}
	public void setTableState(String tableState) {
		this.tableState = tableState;
	}
	
	
	
}
