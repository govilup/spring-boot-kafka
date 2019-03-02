package com.buntyray.producerconsumer.producerconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
public class KafkaSource {

	@Autowired
	private Source source;

	@PostMapping("/messages")
	public String sendMessage(@RequestBody String message) {
		this.source.output().send(new GenericMessage<>(message));
		return message;
	}

}
