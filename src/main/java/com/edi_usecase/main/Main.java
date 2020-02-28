package com.edi_usecase.main;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.edi_usecase.routes.EDIToXMLRoute;

public class Main {

	public static void main(String args[]) {
		
		//	Creating a new object of camel context
		CamelContext camelContext = new DefaultCamelContext();
		//	Creating a new object of edi to xml route
		EDIToXMLRoute ediToXmlRoute = new EDIToXMLRoute();
		try {
			//	Adding the route to the camel context
			camelContext.addRoutes(ediToXmlRoute);
			//	Starting the camel context
			camelContext.start();
			//	Giving camel time to process the file
			Thread.sleep(4000);
			//	Stopping the camel context
			camelContext.stop();
		} catch (InterruptedException e) {
			System.out.println("Error!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		}

	}

}
