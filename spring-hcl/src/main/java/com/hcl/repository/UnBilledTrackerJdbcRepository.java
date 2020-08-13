package com.hcl.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.hcl.entity.UnBilledTracker;

public interface UnBilledTrackerJdbcRepository {

	List<UnBilledTracker> getEBDLWDTRFOutDateGreaterThanEqual(Date date);
	public List<UnBilledTracker> findAllByCategoryType(String categoryType);
	public List<UnBilledTracker> findAllByCategoryTypeAndMonthAndYear(String categoryType, int year, int month);
	public List<UnBilledTracker> findAllByCategoryTypeAndYear(String categoryType, int year);
	public List<UnBilledTracker> findWithCatAndPlan(String categoryType, String plan);
	public List<UnBilledTracker> findWithCatAndAge(String categoryType, String age);
	public List<UnBilledTracker> findAllByAdjustedDUAndPlan(String Du, String Plan);
	public List<UnBilledTracker> findAllByAdjustedDU(String Du);
	public List<UnBilledTracker> findAllByAdjustedDUAndUnbillAgeingLessThanEqual(String Du, int Age);
	public List<UnBilledTracker> findAllByadjustedDUAndUnbillAgeingGreaterThan(String Du, int Age);
	public List<UnBilledTracker> findAllByAdjustedDUAndUnbillAgeingGreaterThanAndUnbillAgeingLessThanEqual(String du, int i, int j);
	//@Query(value="select * from UnBilled_Tracker where Adjusted_Du = ? and DATEPART(YYYY,EBD_LWD_TRF_Out_Date)=?",nativeQuery=true)
	public List<UnBilledTracker> findAllByDuAndYear(String du, int year);
	//@Query(value="select * from UnBilled_Tracker where Adjusted_Du = ? and DATEPART(YYYY,EBD_LWD_TRF_Out_Date)=? and DATEPART(MONTH,EBD_LWD_TRF_Out_Date)=? ",nativeQuery=true)
	public List<UnBilledTracker> findAllByDuAndMonthAndYear(String du, int year, int month);
	
}
