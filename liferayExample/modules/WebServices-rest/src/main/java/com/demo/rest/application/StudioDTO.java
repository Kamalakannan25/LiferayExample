package com.demo.rest.application;

public class StudioDTO {

    private String cameraName;
    private String cameraModel;
    private long cameraPrice;
	
    public String getCameraName() {
		return cameraName;
	}
	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}
	public String getCameraModel() {
		return cameraModel;
	}
	public void setCameraModel(String cameraModel) {
		this.cameraModel = cameraModel;
	}
	public long getCameraPrice() {
		return cameraPrice;
	}
	public void setCameraPrice(long cameraPrice) {
		this.cameraPrice = cameraPrice;
	}
   
}
