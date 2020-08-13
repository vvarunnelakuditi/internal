package com.hcl.service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.entity.Goals;
import com.hcl.repository.GoalJdbcRepository;

@Service
public class GoalsServiceImpl implements GoalsService {


	
	private GoalJdbcRepository goalJdbcRepository;

	@Autowired
	GoalsServiceImpl(GoalJdbcRepository goalJdbcRepository) {
	
		this.goalJdbcRepository=goalJdbcRepository;

	}

	@Override
	public List<Goals> getAllgoalsByYear(String year) {
		List<Goals> list = goalJdbcRepository.getAllGoalsByYear(year);
		//list.removeIf(Objects::isNull);
		return list;
	}

	@Override
	public List<Goals> getSpecificGoal(String level) {

		return goalJdbcRepository.getSpecificGoal(level);
	}

	@Override
	public List<Goals> getSpecificduGoal(String level) {
		return goalJdbcRepository.getSpecificduGoal(level);
	}

	@Override
	@Transactional
	public void updateOrSaveTheGoal(Goals goals) {
		goalJdbcRepository.updateOrSaveTheGoal(goals);

	}
	
	///////////////////////////////////////////////////////////////////////////////
	
	
		public List<Goals> selectUtilizationGoal(String goalYear){
			return goalJdbcRepository.usp_wpc_GetGoals(goalYear);
		}

		public GoalsServiceImpl() {
			super();
		}

}
