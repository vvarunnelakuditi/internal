package com.hcl.entity;



public class Goals implements Cloneable{

	
	private String parameter;
	private Double effectiveUtil;
	private Double unbilledInProjects;
	private Double internalProjects;
	private Double bench;
	private Double deliverySupport;
	
	private String year;

	private String type;

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public Double getEffectiveUtil() {
		return effectiveUtil;
	}

	public void setEffectiveUtil(Double effectiveUtil) {
		this.effectiveUtil = effectiveUtil;
	}

	public Double getUnbilledInProjects() {
		return unbilledInProjects;
	}

	public void setUnbilledInProjects(Double unbilledInProjects) {
		this.unbilledInProjects = unbilledInProjects;
	}

	public Double getInternalProjects() {
		return internalProjects;
	}

	public void setInternalProjects(Double internalProjects) {
		this.internalProjects = internalProjects;
	}

	public Double getBench() {
		return bench;
	}

	public void setBench(Double bench) {
		this.bench = bench;
	}

	public Double getDeliverySupport() {
		return deliverySupport;
	}

	public void setDeliverySupport(Double deliverySupport) {
		this.deliverySupport = deliverySupport;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Goals(String parameter, Double effectiveUtil, Double unbilledInProjects, Double internalProjects, Double bench,
			Double deliverySupport, String year, String type) {
		super();
		this.parameter = parameter;
		this.effectiveUtil = effectiveUtil;
		this.unbilledInProjects = unbilledInProjects;
		this.internalProjects = internalProjects;
		this.bench = bench;
		this.deliverySupport = deliverySupport;
		this.year = year;
		this.type = type;
	}

	public Goals() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 public Object clone() throws
     CloneNotSupportedException 
{ 
return super.clone(); 
} 

}
