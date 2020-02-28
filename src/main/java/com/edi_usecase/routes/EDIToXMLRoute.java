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
		
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(new File(".").getCanonicalPath() + File.separator + "java.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String topicName = properties.getProperty("topicname"); 
		String kafkaServer = properties.getProperty("kafkaserver");
		String zooKeeperHost = properties.getProperty("zooKeeperhost");
		String serializerClass = properties.getProperty("serializerclass");

		String toKafka = new StringBuilder().append(kafkaServer).append("?").append(topicName).append("&")
				.append(zooKeeperHost).append("&").append(serializerClass).toString();

		from(properties.getProperty("ediinput")).to("smooks://smooks-config.xml")
		.to((String)"xslt:transform.xslt").to(toKafka);
		
	}
}
