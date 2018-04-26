package org.mas.info;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mas.info.resource.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = {"/application-test.properties","/broker.xml.bak"})
public class AlfredOutilConverterApplicationTests {
	
	@Autowired
	private JmsProducer producer;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void send(){
		producer.send("MyMessage");
		
		System.out.println("ConnectionFactory ----------------> " + jmsTemplate.getConnectionFactory());
		System.out.println("DefaultDestinationName -----------> " + producer.getJmsTemplate().getDefaultDestinationName());
		System.out.println("MessageConverter -----------------> " + jmsTemplate.getMessageConverter().toString());
		
		jmsTemplate.setReceiveTimeout(20_000);
		assertThat(jmsTemplate.receiveAndConvert("exampleQueue")).isEqualTo("MyMessage");
	}
}
