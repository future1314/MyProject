package cn.edu.scau.logistics.entity;

public class VehicleSch {
	private int carId;
	private int ordertableDetailId;
	private String carSend;
	private String carArrive;

	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getOrdertableDetailId() {
		return ordertableDetailId;
	}
	public void setOrdertableDetailId(int ordertableDetailId) {
		this.ordertableDetailId = ordertableDetailId;
	}
	public String getCarSend() {
		return carSend;
	}
	public void setCarSend(String carSend) {
		this.carSend = carSend;
	}
	public String getCarArrive() {
		return carArrive;
	}
	public void setCarArrive(String carArrive) {
		this.carArrive = carArrive;
	}
	
}
