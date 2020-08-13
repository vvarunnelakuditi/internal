package com.hcl.entity;

import java.sql.Date;
import org.json.simple.JSONObject;

import com.hcl.util.ConstantUtility;

public class UnBilledTracker {

	private Double employeeCode;
	private String employeeName;
	private String adjustedDU;
	private String categoryType;
	private String plan;
	private Integer plan_Change_Count;
	private Integer unbillAgeing;
	private Date eBDLWDTRFOutDate;
	private String remarks;
	private Date lastUpdated;

	public Double getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Double employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAdjustedDU() {
		return adjustedDU;
	}

	public void setAdjustedDU(String adjustedDU) {
		this.adjustedDU = adjustedDU;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public Integer getPlan_Change_Count() {
		return plan_Change_Count;
	}

	public void setPlan_Change_Count(Integer plan_Change_Count) {
		this.plan_Change_Count = plan_Change_Count;
	}

	public Integer getUnbillAgeing() {
		return unbillAgeing;
	}

	public void setUnbillAgeing(Integer unbillAgeing) {
		this.unbillAgeing = unbillAgeing;
	}

	public Date geteBDLWDTRFOutDate() {
		return eBDLWDTRFOutDate;
	}

	public void seteBDLWDTRFOutDate(Date eBDLWDTRFOutDate) {
		this.eBDLWDTRFOutDate = eBDLWDTRFOutDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public UnBilledTracker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnBilledTracker(Double employeeCode, String employeeName, String adjustedDU, String categoryType, String plan,
			Integer plan_Change_Count, Integer unbillAgeing, Date eBDLWDTRFOutDate, String remarks, Date lastUpdated) {
		super();
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.adjustedDU = adjustedDU;
		this.categoryType = categoryType;
		this.plan = plan;
		this.plan_Change_Count = plan_Change_Count;
		this.unbillAgeing = unbillAgeing;
		this.eBDLWDTRFOutDate = eBDLWDTRFOutDate;
		this.remarks = remarks;
		this.lastUpdated = lastUpdated;
	}

	public JSONObject unBilledL4PlanDataWithOutMonthAndYear() {
		JSONObject re = new JSONObject();
		try {
			re.put("Employee_Code", this.employeeCode);
			re.put("Employee_Name", this.employeeName);
			re.put("Adjusted_DU", this.adjustedDU);
			re.put("Category_Type", this.categoryType);
			re.put("Plan", this.plan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public JSONObject unBilledL4PlanDataWithMonthAndYear() {
		JSONObject re = new JSONObject();
		try {
			re.put("Employee_Code", this.employeeCode);
			re.put("Employee_Name", this.employeeName);
			re.put("Adjusted_DU", this.adjustedDU);
			re.put("Category_Type", this.categoryType);
			re.put("Plan", this.plan);

			String date = ConstantUtility.getMontAndYear(this.eBDLWDTRFOutDate);
			re.put("month", date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

}
