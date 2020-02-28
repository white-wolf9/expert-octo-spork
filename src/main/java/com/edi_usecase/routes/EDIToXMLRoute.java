package com.edi_usecase.routes;

import org.apache.camel.builder.RouteBuilder;

public class EDIToXMLRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		String topicName = "topic=InitialTopic";
		String kafkaServer = "kafka:localhost:9092";
		String zooKeeperHost = "zookeeperHost=localhost&zookeeperPort=2181";
		String serializerClass = "serializerClass=kafka.serializer.StringEncoder";

		String toKafka = new StringBuilder().append(kafkaServer).append("?").append(topicName).append("&")
				.append(zooKeeperHost).append("&").append(serializerClass).toString();

		from("file:D://inputFolder").to("smooks://smooks-config.xml")
		.to((String)"xslt:transform.xslt").split().tokenize("\n").to(toKafka);
		
	}
}
