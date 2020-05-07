package io.spring.dataflow.sample.domain;

import lombok.Data;
@Data
public class UsageDetail {

	public UsageDetail() { }

	private String userId;
	private long duration;
	private long data;

}
