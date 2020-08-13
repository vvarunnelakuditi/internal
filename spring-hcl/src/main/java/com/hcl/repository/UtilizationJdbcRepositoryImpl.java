package com.hcl.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hcl.entity.ProjectBillSplit;
import com.hcl.entity.Utilization;

@Repository
public class UtilizationJdbcRepositoryImpl implements UtilizationJdbcRepository{

	@Autowired 
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate JdbcTemplate;
	
	@Override
	public List<Utilization> findAll(Date MaxDate) {
		String sql = "SELECT * FROM dbo.Utilization WHERE Calendar_Day ='"+MaxDate+"'";
		List<Map<String, Object>> rows = JdbcTemplate.queryForList(sql);
		List<Utilization> result = new ArrayList<Utilization>();
		for(Map<String, Object> row:rows){
			Utilization um = new Utilization();
			um.setCalendar_Day(MaxDate);
			um.setLevel((String)row.get("Level"));
			um.setEffective_Utilization((Double)row.get("Effective_Utilization"));
			um.setUnbilled_In_Projects((Double)row.get("Unbilled_In_Projects"));
			um.setInternal_Projects_SUT((Double)row.get("Internal_Projects_SUT"));
			um.setBench((Double)row.get("Bench"));
			um.setDelivery_Support((Double)row.get("Delivery_Support"));
			result.add(um);
			}
		return result;
	}
	
	/*
	 * To retireve the Max date for the Query. This can be used as a common function for other requirements. 
	 */

	@Override
	public Date FindMaxDate(String TableName) {
		String sql= "select MAX(Calendar_Day) from "+TableName;
		Date forMaxDate = JdbcTemplate.queryForObject(sql, Date.class);
	return forMaxDate ;
	}
//varun
	@Override
	public Date FindMaxDate() {
		String sql= "select MAX(Calendar_Day) from Utilization";
		Date forMaxDate = JdbcTemplate.queryForObject(sql, Date.class);
	return forMaxDate ;
	}

	@Override
	public List<String> FindDUListOrderByLevelAsc(Date date) {
		String sql= "select distinct Level from Utilization where Calendar_Day = '"+date+"' order by Level Asc";
		List<Map<String, Object>> listOfFY = JdbcTemplate.queryForList(sql);
		List<String> result = new ArrayList<String>();
		for(Map<String, Object> eachOfFY:listOfFY) {
			result.add(eachOfFY.get("Level").toString());
		}
	return result ;
	}

	@Override
	public List<Utilization> FindRecords(Date startDate, Date endDate) {
		String sql = "select Calendar_Day,Level,Effective_Utilization,Unbilled_In_Projects,Internal_Projects_SUT,Bench,Delivery_Support from Utilization where Calendar_Day >= '"+startDate +"' and Calendar_Day <= '"+ endDate+"'";
		List<Map<String, Object>> rows = JdbcTemplate.queryForList(sql);
		List<Utilization> result = new ArrayList<Utilization>();
		for(Map<String, Object> row:rows){
			Utilization um = new Utilization();
			if(row.get("Calendar_Day")!=null)
			um.setCalendar_Day((Date)row.get("Calendar_Day"));
			if(row.get("Level")!=null)
			um.setLevel((String)row.get("Level"));
			if(row.get("Effective_Utilization")!=null)
			um.setEffective_Utilization((Double)row.get("Effective_Utilization"));
			else um.setEffective_Utilization((double) 0); 
			if(row.get("Unbilled_In_Projects")!=null)
			um.setUnbilled_In_Projects((Double)row.get("Unbilled_In_Projects"));
			else um.setUnbilled_In_Projects((double)0);
			if(row.get("Internal_Projects_SUT")!=null)
			um.setInternal_Projects_SUT((Double)row.get("Internal_Projects_SUT"));
			else um.setInternal_Projects_SUT((double)0);
			if(row.get("Bench")!=null)
			um.setBench((Double)row.get("Bench"));
			else um.setBench((double)0);
			if(row.get("Delivery_Support")!=null)
			um.setDelivery_Support((Double)row.get("Delivery_Support"));
			else um.setDelivery_Support((double)0);
			result.add(um);
			}
		return result;
	}
}
