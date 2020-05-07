package io.spring.dataflow.sample.usagecostlogger;

import io.spring.dataflow.sample.domain.UsageCostDetail;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@Slf4j
public class UsageCostLogger {

	@StreamListener(Sink.INPUT)
	public void process(UsageCostDetail usageCostDetail) {
		log.info(usageCostDetail.toString());
	}
}