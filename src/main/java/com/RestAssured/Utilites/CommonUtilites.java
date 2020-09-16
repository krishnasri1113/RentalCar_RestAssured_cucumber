package com.RestAssured.Utilites;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CommonUtilites {
	public static Properties props=new Properties();
	static FileInputStream filein;
	 Logger log = Logger.getLogger(getClass().getSimpleName());
	 public void loadlog4jproperties(String PropertyFilePath) throws Exception
		{
			log.info("Log4j PropertyFile Path "+PropertyFilePath);
			filein=new FileInputStream(PropertyFilePath);
			props.load(filein);
			PropertyConfigurator.configure(props);
		}

}
