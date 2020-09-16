package com.RestAssured.Utilites;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.github.tomakehurst.wiremock.WireMockServer;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestBase {
	public static int port=8088;
	public WireMockServer wiremockserver;
	public Logger log = Logger.getLogger(TestBase.class);
	public static CommonUtilites commonutil=new CommonUtilites();



}
