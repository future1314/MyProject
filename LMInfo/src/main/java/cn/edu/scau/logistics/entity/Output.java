package cn.edu.scau.logistics.entity;

public class Output {
	private int outputId;
	private int ordertableDetailId;
	private String outputCategory;
	private String outputName;
	private String outputNum;
	private String outputTrueNum;
	private String outputTime;
	private String isOutput;
	private String outputOther;
	public int getOutputId() {
		return outputId;
	}
	public void setOutputId(int outputId) {
		this.outputId = outputId;
	}
	public int getOrdertableDetailId() {
		return ordertableDetailId;
	}
	public void setOrdertableDetailId(int ordertableDetailId) {
		this.ordertableDetailId = ordertableDetailId;
	}
	public String getOutputCategory() {
		return outputCategory;
	}
	public void setOutputCategory(String outputCategory) {
		this.outputCategory = outputCategory;
	}
	public String getOutputName() {
		return outputName;
	}
	public void setOutputName(String outputName) {
		this.outputName = outputName;
	}
	public String getOutputNum() {
		return outputNum;
	}
	public void setOutputNum(String outputNum) {
		this.outputNum = outputNum;
	}
	public String getOutputTrueNum() {
		return outputTrueNum;
	}
	public void setOutputTrueNum(String outputTrueNum) {
		this.outputTrueNum = outputTrueNum;
	}
	public String getOutputTime() {
		return outputTime;
	}
	public void setOutputTime(String outputTime) {
		this.outputTime = outputTime;
	}
	public String getIsOutput() {
		return isOutput;
	}
	public void setIsOutput(String isOutput) {
		this.isOutput = isOutput;
	}
	public String getOutputOther() {
		return outputOther;
	}
	public void setOutputOther(String outputOther) {
		this.outputOther = outputOther;
	}
	
}
