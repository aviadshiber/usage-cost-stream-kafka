package io.spring.dataflow.sample.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsageCostDetail {

	private String userId;
	private double callCost;
	private double dataCost;
}
