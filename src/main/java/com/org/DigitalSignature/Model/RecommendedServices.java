package com.org.DigitalSignature.Model;

public class RecommendedServices {
	String upsell;
	double value;
	String service1;
	String service2;
	String service3;
	String service4;

	public RecommendedServices() {
		super();
	}
	public RecommendedServices(String upsell, double value, String service1, String service2, String service3, String service4) {
		super();
		this.upsell = upsell;
		this.value = value;
		this.service1 = service1;
		this.service2 = service2;
		this.service3 = service3;
		this.service4 = service4;
	}
	public String getUpsell() {
		return upsell;
	}
	public void setUpsell(String upsell) {
		this.upsell = upsell;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getService1() {
		return service1;
	}
	public void setService1(String service1) {
		this.service1 = service1;
	}
	public String getService2() {
		return service2;
	}
	public void setService2(String service2) {
		this.service2 = service2;
	}
	public String getService3() {
		return service3;
	}
	public void setService3(String service3) {
		this.service3 = service3;
	}

	public String getService4(){
		return service4;
	}

	public void setService4(String service4){
		this.service4 = service4;
	}
}
