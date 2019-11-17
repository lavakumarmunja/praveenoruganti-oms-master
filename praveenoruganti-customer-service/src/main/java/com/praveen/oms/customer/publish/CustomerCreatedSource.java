package com.praveen.oms.customer.publish;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomerCreatedSource {
	@Output("customerCreatedChannel")
	MessageChannel customerCreated();
}
