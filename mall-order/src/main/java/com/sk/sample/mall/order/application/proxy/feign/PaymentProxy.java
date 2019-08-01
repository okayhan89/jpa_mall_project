package com.sk.sample.mall.order.application.proxy.feign;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sk.sample.mall.order.application.proxy.feign.dto.account.Account;
import com.sk.sample.mall.order.application.proxy.feign.dto.payment.Payment;

@Service
public class PaymentProxy {
	@Autowired
	private PaymentClient paymentClient;
	
	public Payment pay(Payment payment) {
		return paymentClient.pay(payment);
	}

	@FeignClient(name="payments", url="http://localhost:11005", configuration=FeignClientConfiguration.class)
	interface PaymentClient {
		@GetMapping("v1/payments")
		Payment pay(Payment payment);
	}
}

