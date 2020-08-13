package com.hcl.repository;

import java.sql.Date;
import java.util.List;


import com.hcl.entity.ProjectBillSplit;

public interface ProjectBillSplitRepository /* extends jparepository<projectbillsplit,dayandlevel> */{
	//@Query(value="select Calendar_Day,Level,SSB,SUT,IFD_Freshers,C_unbilled_Freshers,Billed_Freshers from Project_Bill_Split where Calendar_Day>=? and Calendar_Day<=?",nativeQuery=true)
	public List<ProjectBillSplit> FindRecords(Date startDate,Date endDate);
}
