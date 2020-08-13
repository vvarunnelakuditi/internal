package com.hcl.repository;

import java.sql.Date;
import java.util.List;

import com.hcl.entity.Utilization;

public interface UtilizationJdbcRepository {

	public List<Utilization> findAll(Date MaxDate);
	public Date FindMaxDate(String TableName);
	public Date FindMaxDate();
	public List<String> FindDUListOrderByLevelAsc(Date date);
	public List<Utilization> FindRecords(Date startDate,Date endDate);
}
