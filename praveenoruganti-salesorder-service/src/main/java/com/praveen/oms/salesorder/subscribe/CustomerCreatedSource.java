package com.praveen.oms.salesorder.subscribe;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomerCreatedSource {
	String INPUT = "customerCreatedChannel";

	@Input
	SubscribableChannel customerCreatedChannel();
}
