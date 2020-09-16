package com.RestAssured.StepDefinitionFile;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.containsString;


import com.RestAssured.Utilites.TestBase;
import com.github.tomakehurst.wiremock.WireMockServer;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class stepdefinitionfile  extends TestBase {
	 public  Response getdataresponse;
	 @Before
	 public void user_starts_the_wiremock_server() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions

	     wiremockserver =new WireMockServer(port);
	     wiremockserver.start();
	     commonutil.loadlog4jproperties(System.getProperty("user.dir")+"/src/main/resources/Properties/Log4j.properties");
	     
	   
	 }

	
	 @Given("^stubbingmapping for getrequest$")
	 public void stubbingmapping_for_getrequest() throws Throwable {
	      // Write code here that turns the phrase above into concrete actions
		 wiremockserver.stubFor(
					get(urlEqualTo("/getcarsdetails"))
					.withHeader("Content-Type",equalTo("application/json; charset=UTF-8"))
					.willReturn(
							aResponse()
							.withStatus(200)
							.withHeader("Content-Type","application/json; charset=UTF-8")
							.withBodyFile("RentalCarsSchema.json")
							));
		
	 }


	 

	
	@When("^user calls the get request API with GET http request$")
	public void user_calls_the_get_request_API_with_GET_http_request() throws Throwable {
		String sHostname="http://localhost:8088";
		String sURI="/getcarsdetails";
		String sURL=sHostname+sURI;
		RestAssured.baseURI=sURL;
		getdataresponse=RestAssured.given().contentType("application/json").get();
	    
	}

	@Then("^user should see the response body$")
	public void user_should_see_the_response_body() throws Throwable {
	   System.out.println(getdataresponse.asString());
	}

	@Then("^The API call got the success with status code (\\d+)$")
	public void the_API_call_got_the_success_with_status_code(int code) throws Throwable {
		System.out.println(getdataresponse.statusCode());
	    
	}

	@Then("^get all blue Teslas from the response$")
	public void get_all_blue_Teslas_from_the_response() throws Throwable {
		getdataresponse=RestAssured.given().contentType("application/json").get();
		//System.out.println(getdataresponse.asString());
		System.out.println("Status code of the response "+getdataresponse.statusCode());
		List<String> limake=getdataresponse.jsonPath().getList("Cars.make");
		System.out.println(limake);
		log.info("Name of the cars are "+limake);
		List<String> licolor=getdataresponse.jsonPath().get("Cars.metadata.Color");
		System.out.println(licolor);
		log.info("Car colors are" +licolor);
		List<String> linotes=getdataresponse.jsonPath().get("Cars.metadata.Notes");
		List<String> licars=getdataresponse.jsonPath().getList("Cars");
		System.out.println(licars.size());
		for(int i=0;i<licolor.size();i++)
		{
			if(licolor.get(i).equalsIgnoreCase("Blue"))
			{
				System.out.println("Blue color cars are:"+limake.get(i));
				 String carcolor=licolor.get(i);
				 System.out.println(carcolor);
				 log.info("Blue clor cars are "+limake.get(i));
				System.out.println("Blue color Tesla notes are: "+linotes.get(i));
				log.info("Blue color car notes are "+linotes.get(i));
				assertThat(carcolor,containsString("Blue"));
			}
			
		}
		

	    
	}

	@Then("^Return all cars which have  the lowest per day price$")
	public void return_all_cars_which_have_the_lowest_per_day_price() throws Throwable {
		//System.out.println("hello");
	 getdataresponse=RestAssured.given().contentType("application/json").get();
	 System.out.println("Status code of the response "+getdataresponse.statusCode());
		List<Float> liperdayrent=getdataresponse.jsonPath().getList("Cars.perdayrent");
		System.out.println("Perday rent of all cars"+liperdayrent);
		log.info("Per day rent of all cars are "+liperdayrent);
		ArrayList<Perdayrentprice> alperdayrentprice=new ArrayList<Perdayrentprice>();
		for(int i=0;i<liperdayrent.size();i++)
		{
			String model=getdataresponse.jsonPath().getString("Cars["+i+"].model");
			System.out.println("Car model is:"+model);
			Integer perdayrentprice=getdataresponse.jsonPath().getInt("Cars["+i+"].perdayrent.Price");
			System.out.println("Perday rent price of the car "+perdayrentprice);
			alperdayrentprice.add(new Perdayrentprice(model,perdayrentprice));
		}
		Collections.sort(alperdayrentprice);
		System.out.println("Return all cars which have the lowest perdayrent prcice ");
		Iterator<Perdayrentprice> it =alperdayrentprice.iterator();
		while(it.hasNext())
		{
			Perdayrentprice tempPerdayrentprice=it.next();
			System.out.println("car model is "+tempPerdayrentprice.model+" Price of that car "+tempPerdayrentprice.perdayrentprice);
		}
		 assertThat(Integer.valueOf(100),comparesEqualTo(alperdayrentprice.get(0).perdayrentprice));
	}

	@Then("^Return all cars which have lowest  the per day price after discount$")
	public void return_all_cars_which_have_lowest_the_per_day_price_after_discount() throws Throwable {
		//System.out.println("hello");
		 getdataresponse=RestAssured.given().contentType("application/json").get();
			System.out.println("Status code of the response "+getdataresponse.statusCode());
			List<Float> liperdayrent=getdataresponse.jsonPath().getList("Cars.perdayrent");
			System.out.println("Perday rent of all cars"+liperdayrent);
			log.info("Per day rent of all cars are "+liperdayrent);
			ArrayList<Perdayrentprice> alperdayrentprice=new ArrayList<Perdayrentprice>();
			ArrayList<Perdayrentafterdiscount> alperdayrentafterdiscount=new ArrayList<Perdayrentafterdiscount>();
			for(int i=0;i<liperdayrent.size();i++)
			{
				String model=getdataresponse.jsonPath().getString("Cars["+i+"].model");
				System.out.println("Car model is:"+model);
				Integer perdayrentprice=getdataresponse.jsonPath().getInt("Cars["+i+"].perdayrent.Price");
				System.out.println("Perday rent price of the car "+perdayrentprice);
				Integer perdaydiscount=getdataresponse.jsonPath().getInt("Cars["+i+"].perdayrent.Discount");
				System.out.println("Perday rent price of the car discount is "+perdaydiscount);
				Integer perdaypriceafterdiscount=(perdayrentprice-(perdayrentprice*perdaydiscount/100));
					System.out.println("perday rent of the car price after discount is "+perdaypriceafterdiscount);
					alperdayrentafterdiscount.add(new Perdayrentafterdiscount(model,perdaypriceafterdiscount));
			}
			Collections.sort(alperdayrentafterdiscount);
			Iterator<Perdayrentafterdiscount> it1=alperdayrentafterdiscount.iterator();
			while(it1.hasNext())
			{
				Perdayrentafterdiscount tempPerdayRentafterdiscount=it1.next();
				System.out.println("car model is "+tempPerdayRentafterdiscount.model+" Price after discount of that car is "+tempPerdayRentafterdiscount.perdayrentafterdiscount);
			}
			assertThat(Integer.valueOf(90),comparesEqualTo(alperdayrentafterdiscount.get(0).perdayrentafterdiscount));
	    
	}

	@Then("^Return all cars which have  the highest  Revenue$")
	public void return_all_cars_which_have_the_highest_Revenue() throws Throwable {
	   // System.out.println("hello");
		getdataresponse=RestAssured.given().contentType("application/json").get();
		List<Float> limetrics=getdataresponse.jsonPath().getList("Cars.metrics");
		System.out.println(limetrics);
		System.out.println(limetrics.size());
		ArrayList<HighestCarRevnue> alhighestcarRevnue=new ArrayList<HighestCarRevnue>();
		for(int i=0;i<limetrics.size();i++)
		{
			String model=getdataresponse.jsonPath().getString("Cars["+i+"].model");
			System.out.println("Car model is "+model);
			Float yoymaintenancecost=getdataresponse.jsonPath().getFloat("Cars["+i+"].metrics.yoymaintenancecost");
			System.out.println("yoy maintaince cost is "+yoymaintenancecost);
			Float depreciation=getdataresponse.jsonPath().getFloat("Cars["+i+"].metrics.depreciation");
			System.out.println("the depreciation is "+depreciation);
			Float yearTodate=getdataresponse.jsonPath().getFloat("Cars["+i+"].metrics.rentalcount.yeartodate");
			System.out.println("year to date  is "+yearTodate);
			Integer perdayrentprice=getdataresponse.jsonPath().getInt("Cars["+i+"].perdayrent.Price");
			System.out.println("Perday rent price of the car "+perdayrentprice);
			Integer perdaydiscount=getdataresponse.jsonPath().getInt("Cars["+i+"].perdayrent.Discount");
		System.out.println("Perday rent discount  of the car "+perdaydiscount);
		Integer perdaypriceafterdiscount=(perdayrentprice-(perdayrentprice*perdaydiscount/100));
			System.out.println("Perday rent aftter discount is "+perdaypriceafterdiscount);
			Float carRevenue=((yearTodate*perdaypriceafterdiscount)-(yoymaintenancecost+depreciation));
			System.out.println("car revnue is "+carRevenue);
			alhighestcarRevnue.add(new HighestCarRevnue(model,carRevenue));
		}
		Collections.sort(alhighestcarRevnue,Collections.reverseOrder());
		System.out.println("highest revnue cars are");
		Iterator<HighestCarRevnue> it=alhighestcarRevnue.iterator();
		while(it.hasNext())
		{
			HighestCarRevnue obj=it.next();
			System.out.println("car model is "+obj.model+" Highest car revenues are "+obj.fcarRevnue);
		}
		assertThat(Float.valueOf((float)21998.81),comparesEqualTo(alhighestcarRevnue.get(0).fcarRevnue));
		
	}
	  
	
	 @After
	 public void quit_the_wiremockserver() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 wiremockserver.stop();
	    
	 }


	 



}
