package com.RestAssured.StepDefinitionFile;


public class Perdayrentafterdiscount implements Comparable<Perdayrentafterdiscount> {
	String model;
	int perdayrentafterdiscount;

	public Perdayrentafterdiscount(String model, int perdaypriceafterdiscount) {
		// TODO Auto-generated constructor stu
		this.model=model;
		this.perdayrentafterdiscount=perdaypriceafterdiscount;
		
	}

	public int compareTo(Perdayrentafterdiscount o) {
		// TODO Auto-generated method stub
		return this.perdayrentafterdiscount-o.perdayrentafterdiscount;
	}
 

}
