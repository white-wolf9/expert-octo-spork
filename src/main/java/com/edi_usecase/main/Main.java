package com.edi_usecase.main;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.edi_usecase.routes.EDIToXMLRoute;

public class Main {

	public static void main(String args[]) {
		System.out.println("Initialized");
		CamelContext camelContext = new DefaultCamelContext();
		EDIToXMLRoute ediToXmlRoute = new EDIToXMLRoute();
		try {
			camelContext.addRoutes(ediToXmlRoute);
			camelContext.start();
			Thread.sleep(6000);
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
