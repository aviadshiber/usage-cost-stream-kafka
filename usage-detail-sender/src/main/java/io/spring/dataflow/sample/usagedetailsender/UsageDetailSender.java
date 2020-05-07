package io.spring.dataflow.sample.usagedetailsender;

import java.util.Random;

import io.spring.dataflow.sample.domain.UsageDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@EnableBinding(Source.class)
public class UsageDetailSender {

	private final Source source;

	private final String[] users = {"Amit", "Tom", "Guy", "Shahar", "Aviad"};

	@Autowired
	public UsageDetailSender(Source source) {
		this.source = source;
	}

	@Scheduled(fixedDelay = 1000)
	public void sendEvents() {
		UsageDetail usageDetail = new UsageDetail();
		usageDetail.setUserId(this.users[new Random().nextInt(5)]);
		usageDetail.setDuration(new Random().nextInt(300));
		usageDetail.setData(new Random().nextInt(700));
		this.source.output().send(MessageBuilder.withPayload(usageDetail).build());
	}
}
