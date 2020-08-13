package com.hcl.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hcl.entity.ProjectBillSplit;
@Repository
public class ProjectBillSplitRepositoryJDBC implements ProjectBillSplitRepository {
	@Autowired
	JdbcTemplate JdbcTemplate;
//varun
	@Override
	public List<ProjectBillSplit> FindRecords(Date startDate, Date endDate) {
		String sql = "select Calendar_Day,Level,SSB,SUT,IFD_Freshers,C_unbilled_Freshers,Billed_Freshers from Project_Bill_Split where Calendar_Day>='"+startDate +"' and Calendar_Day<='"+endDate +"'";
		List<Map<String, Object>> listOfFY = JdbcTemplate.queryForList(sql);
		List<ProjectBillSplit> result = new ArrayList<ProjectBillSplit>();
		for(Map<String, Object> eachOfFY:listOfFY) {
			ProjectBillSplit projectBillSplit= new ProjectBillSplit();
			if(eachOfFY.get("Billed_Freshers")!=null) 
			projectBillSplit.setBilled_Freshers(((Double)eachOfFY.get("Billed_Freshers")).floatValue());
			else projectBillSplit.setBilled_Freshers((float) 0); 
			if(eachOfFY.get("C_unbilled_Freshers")!=null) 
			projectBillSplit.setC_unbilled_Freshers(((Double)eachOfFY.get("C_unbilled_Freshers")).floatValue());
			else projectBillSplit.setC_unbilled_Freshers((float) 0);
			if(eachOfFY.get("Calendar_Day")!=null) 
			projectBillSplit.setCalendar_Day((Date)eachOfFY.get("Calendar_Day"));
			if(eachOfFY.get("IFD_Freshers")!=null) 
			projectBillSplit.setIFD_Freshers(((Double)eachOfFY.get("IFD_Freshers")).floatValue());
			else projectBillSplit.setIFD_Freshers((float) 0);
			if(eachOfFY.get("Level")!=null) 
			projectBillSplit.setLevel(eachOfFY.get("Level").toString());
			if(eachOfFY.get("SSB")!=null) 
			projectBillSplit.setSSB(((Double)eachOfFY.get("SSB")).floatValue());
			else projectBillSplit.setSSB((float) 0);
			if(eachOfFY.get("SUT")!=null) 
			projectBillSplit.setSUT(((Double)eachOfFY.get("SUT")).floatValue());
			else projectBillSplit.setSUT((float) 0);
			result.add(projectBillSplit);
		}
		return result;
	}

}
