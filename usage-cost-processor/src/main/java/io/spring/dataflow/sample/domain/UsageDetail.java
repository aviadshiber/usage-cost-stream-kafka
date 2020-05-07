package io.spring.dataflow.sample.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsageDetail {

	private String userId;
	private long duration;
	private long data;
}
