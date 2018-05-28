package com.org.DigitalSignature.Model;


public class RecallDetail {
	String recall_number;
	String recall_vehicle_type;
	String recall_reason;
	String recall_start_data;
	public RecallDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecallDetail(String recall_number, String recall_vehicle_type, String recall_reason,
			String recall_start_data) {
		super();
		this.recall_number = recall_number;
		this.recall_vehicle_type = recall_vehicle_type;
		this.recall_reason = recall_reason;
		this.recall_start_data = recall_start_data;
	}
	public String getRecall_number() {
		return recall_number;
	}
	public void setRecall_number(String recall_number) {
		this.recall_number = recall_number;
	}
	public String getRecall_vehicle_type() {
		return recall_vehicle_type;
	}
	public void setRecall_vehicle_type(String recall_vehicle_type) {
		this.recall_vehicle_type = recall_vehicle_type;
	}
	public String getRecall_reason() {
		return recall_reason;
	}
	public void setRecall_reason(String recall_reason) {
		this.recall_reason = recall_reason;
	}
	public String getRecall_start_data() {
		return recall_start_data;
	}
	public void setRecall_start_data(String recall_start_data) {
		this.recall_start_data = recall_start_data;
	}



}
