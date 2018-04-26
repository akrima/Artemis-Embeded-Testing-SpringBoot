package org.mas.info.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {

	@Autowired
	private
	JmsTemplate jmsTemplate;
	
	@Value("${jms.queue.destination}")
	private String destinationQueue;
	
	public void send(String msg){
		getJmsTemplate().convertAndSend(destinationQueue, msg);
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
}
