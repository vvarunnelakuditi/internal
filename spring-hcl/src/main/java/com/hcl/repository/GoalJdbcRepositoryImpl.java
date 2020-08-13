package com.hcl.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Goals;
import com.hcl.util.ConstantUtility;

@Repository
public class GoalJdbcRepositoryImpl implements GoalJdbcRepository {

	private DataSource dataSource;
	@Autowired
	public GoalJdbcRepositoryImpl(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	@Autowired
	JdbcTemplate JdbcTemplate;
	@Override
	public List<Goals> getAllGoalsByYear(String year) {
		List<Goals> result = new ArrayList<Goals>();
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName(ConstantUtility.GET_GOAL_PROCEDURE_NAME);
		SqlParameterSource in = new MapSqlParameterSource().addValue(ConstantUtility.GET_GOAL_PROCEDURE_PARAMETER, year);
		Map<String, Object> out = jdbcCall.execute(in);
		for(Entry<String, Object> row:out.entrySet()){
		result.addAll((Collection<? extends Goals>) row.getValue());
		}
		return result;
	}

	@Override
	public List<Goals> getSpecificGoal(String parameter) {
		List<Goals> result = new ArrayList<Goals>();
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName(ConstantUtility.GET_SPICIFIC_GOAL_PROCEDURE_NAME);
		SqlParameterSource in = new MapSqlParameterSource().addValue(ConstantUtility.GET_SPICIFIC_GOAL_PROCEDURE_PARAMETER, parameter);
		Map<String, Object> out = jdbcCall.execute(in);
		for(Entry<String, Object> row:out.entrySet()){
		result.addAll((Collection<? extends Goals>) row.getValue());
		}
		return result;
	}

	@Override
	public List<Goals> getSpecificduGoal(String level) {
		List<Goals> result = new ArrayList<Goals>();
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName(ConstantUtility.GET_SPICIFIC_GOAL_PROCEDURE_NAME);
		SqlParameterSource in = new MapSqlParameterSource().addValue(ConstantUtility.GET_SPICIFIC_GOAL_PROCEDURE_PARAMETER, level);
		Map<String, Object> out = jdbcCall.execute(in);
		for(Entry<String, Object> row:out.entrySet()){
		result.addAll((Collection<? extends Goals>) row.getValue());
		}
		return result;
	}

	@Override
	public void updateOrSaveTheGoal(Goals goals) {
			Map map = new HashMap<>();
			map.put(ConstantUtility.PARAMETER_TYPE, goals.getParameter());
			map.put(ConstantUtility.EFFECTIVEUTIL_TYPE, goals.getEffectiveUtil());
			map.put(ConstantUtility.UNBILLED_IN_PROJECTS_TYPE, goals.getUnbilledInProjects());
			map.put(ConstantUtility.INTERNAL_PROJECTS_TYPE, goals.getInternalProjects());
			map.put(ConstantUtility.BENCH_TYPE, goals.getBench());
			map.put(ConstantUtility.DELIVERY_SUPPORT_TYPE, goals.getDeliverySupport());
			map.put(ConstantUtility.YEAR_TYPE, goals.getYear());
			map.put(ConstantUtility.TYPE_TYPE, goals.getType());
			
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName(ConstantUtility.EDIT_GOAL_PROCEDURE_NAME);
		SqlParameterSource in = new MapSqlParameterSource().addValues(map);
		Map<String, Object> out = jdbcCall.execute(in);
		System.out.println(out);
		
	}
//varun
	@Override
	public List<Goals> usp_wpc_GetGoals(String Year) {
		List<Goals> result = new ArrayList<Goals>();
//		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("usp_wpc_GetGoals");
//		SqlParameterSource in = new MapSqlParameterSource().addValue("Year", Year);
//		Map<String, Object> out = jdbcCall.execute(in);
//		Object[] liGoal=out.;
		
		String sql= "exec usp_wpc_GetGoals @Year='"+Year+"'";
		List<Map<String, Object>> listOfFY = JdbcTemplate.queryForList(sql);
		
		
		
		for(Map<String, Object> eachOfFY:listOfFY){
			Goals re=new Goals();
			if(eachOfFY.get("Bench")!=null) 
			re.setBench(((BigDecimal)eachOfFY.get("Bench")).doubleValue());
			else re.setBench((double) 0);
			if(eachOfFY.get("Year")!=null)
			re.setYear(eachOfFY.get("Year").toString());
			if(eachOfFY.get("DeliverySupport")!=null)
			re.setDeliverySupport(((BigDecimal)eachOfFY.get("DeliverySupport")).doubleValue());
			else re.setDeliverySupport((double) 0);
			if(eachOfFY.get("EffectiveUtil")!=null)
			re.setEffectiveUtil(((BigDecimal)eachOfFY.get("EffectiveUtil")).doubleValue());
			else re.setEffectiveUtil((double) 0);
			if(eachOfFY.get("InternalProjects")!=null)
			re.setInternalProjects(((BigDecimal)eachOfFY.get("InternalProjects")).doubleValue());
			else re.setInternalProjects((double) 0);
			if(eachOfFY.get("Parameter")!=null)
			re.setParameter(eachOfFY.get("Parameter").toString());
			if(eachOfFY.get("Type")!=null)
			re.setType(eachOfFY.get("Type").toString());
			if(eachOfFY.get("UnbilledInProjects")!=null)
			re.setUnbilledInProjects(((BigDecimal)eachOfFY.get("UnbilledInProjects")).doubleValue());
			else re.setUnbilledInProjects((double) 0);
			result.add(re);
		}
		return result;
	}
//varun
	@Override
	public String FindMaxDate() {
		// TODO Auto-generated method stub
		String sql= "select MAX(Year) from tbl_wpc_Goals";
		String forMaxDate = JdbcTemplate.queryForObject(sql, String.class);
	return forMaxDate ;
	}
	
	
	

}
