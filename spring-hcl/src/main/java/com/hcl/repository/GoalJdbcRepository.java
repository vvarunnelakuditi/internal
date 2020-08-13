package com.hcl.repository;

import java.util.List;


import com.hcl.entity.Goals;

public interface GoalJdbcRepository {

	public List<Goals> getAllGoalsByYear( String year);
	List<Goals> getSpecificGoal( String parameter);
	public List<Goals> getSpecificduGoal(String level);
	public void updateOrSaveTheGoal(Goals goals);
	//@Query(value = "{call usp_wpc_GetGoals(:Year)}",nativeQuery = true)
	public List<Goals> usp_wpc_GetGoals(String Year);
	public String FindMaxDate();
}
