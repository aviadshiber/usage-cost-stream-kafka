package io.spring.dataflow.sample.usagecostprocessor;

import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsageCostProcessorApplicationTests {

	@Autowired
	private Processor processor;

	@Autowired
	private MessageCollector messageCollector;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testUsageCostProcessor() throws Exception {
		this.processor.input().send(MessageBuilder.withPayload("{\"userId\":\"user3\",\"duration\":101,\"data\":502}").build());
		val message = this.messageCollector.forChannel(this.processor.output()).poll(1, TimeUnit.SECONDS);
		assert message != null;
		assertEquals("{\"userId\":\"user3\",\"callCost\":10.100000000000001,\"dataCost\":25.1}", message.getPayload().toString());
	}

}
