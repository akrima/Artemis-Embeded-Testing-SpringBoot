package org.mas.info.controller;

import org.mas.info.resource.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
	
	@Autowired
	JmsProducer jmsProducer;
	
	@RequestMapping(value="/produce")
	public String produce(@RequestParam("msg")String msg){
		jmsProducer.send(msg);
		return "Done";
	}
}