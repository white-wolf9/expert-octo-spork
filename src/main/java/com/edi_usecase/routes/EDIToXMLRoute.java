package com.edi_usecase.routes;

import org.apache.camel.builder.RouteBuilder;

public class EDIToXMLRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("file:D://inputFolder").to("smooks://smooks-config.xml")
		.to("xslt:transform.xslt").to("file:D://outputFolder?fileName=outputFile.xml");
		
	}
}
