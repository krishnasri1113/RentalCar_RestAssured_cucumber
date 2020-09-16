package com.RestAssured.StepDefinitionFile;


public class HighestCarRevnue  implements  Comparable<HighestCarRevnue>{
	
	String model;
	public float fcarRevnue;

	public HighestCarRevnue(String model, Float carRevenue) 
	{
		// TODO Auto-generated constructor stub
		this.model=model;
		this.fcarRevnue=carRevenue;
	}

	public int compareTo(HighestCarRevnue o) {
		// TODO Auto-generated method stub
		return (int) ((float)this.fcarRevnue-o.fcarRevnue);
	}
}
	
