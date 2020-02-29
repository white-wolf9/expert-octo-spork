package com.edi_usecase.routes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.camel.builder.RouteBuilder;

public class EDIToXMLRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//	Creating a properties object
		Properties properties = new Properties();
		try {
			//	Reading the external properties file
			properties.load(new FileReader(new File(".").getCanonicalPath() + File.separator + "java.properties"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//	Using the key value pairs in the properties file to form the kafka path
		String toKafka = new StringBuilder().append(properties.getProperty("kafkaserver")).append("?").append(properties.getProperty("topicname")).append("&")
				.append(properties.getProperty("zooKeeperhost")).append("&").append(properties.getProperty("serializerclass")).toString();
		//	Using the key value pairs in the properties file to form the kafka path
		from(properties.getProperty("ediinput")).to("smooks://smooks-config.xml")
		.to((String)"xslt:transform.xslt").to(toKafka);
		
	}
}
