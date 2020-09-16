package com.RestAssured.StepDefinitionFile;


public class Perdayrentprice implements Comparable<Perdayrentprice> {
public String model;
public int perdayrentprice;

public Perdayrentprice(String model, Integer perdayrentprice) {
	// TODO Auto-generated constructor stub
	this.perdayrentprice=perdayrentprice;
	this.model=model;
}

public int compareTo(Perdayrentprice obj) {
	// TODO Auto-generated method stub
	return this.perdayrentprice-obj.perdayrentprice;
}
	

}
