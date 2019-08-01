package com.sk.sample.mall.order.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.sample.mall.order.application.proxy.feign.AccountProxy;
import com.sk.sample.mall.order.application.proxy.feign.PaymentProxy;
import com.sk.sample.mall.order.application.proxy.feign.ProductProxy;
import com.sk.sample.mall.order.application.proxy.feign.dto.account.Account;
import com.sk.sample.mall.order.application.proxy.feign.dto.payment.Payment;
import com.sk.sample.mall.order.application.proxy.feign.dto.product.Product;
import com.sk.sample.mall.order.domain.model.Order;
import com.sk.sample.mall.order.domain.repository.OrderRepository;

@Service("orderLogic")
public class OrderLogic implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private AccountProxy accountProxy;
	
	@Autowired
	private ProductProxy productProxy;
	
	@Autowired
	private PaymentProxy paymentProxy;
	
	public void purchase(Long orderId) {
		Order order = orderRepository.findOne(orderId);
		
		if(order == null) {
			System.err.println("no purchase");
			return;
		}
		
		System.out.println("Purchase: " + order.toString());
		
		if(order.getPurchased() == true) {
			System.err.println("already purchased");
			return;
		}
		if(order.getCreditCard() == null) {
			System.err.println("no credit card");
			return;
		}
		
		if(order.getShippingAddress() == null) {
			System.err.println("no shippig address");
			return;
		}
		
		Account account = accountProxy.findAccount(order.getBuyerAccountId());
		System.out.println("Buyer: " + account.toString());
			
		Product product = productProxy.findProduct(order.getProductId());
		System.out.println("Product: " + product.toString());
			
		order.setTotalPrice(order.getProductCount() * product.getPrice().getValue());
		
		Payment payment = new Payment(order.getCreditCard(), order.getTotalPrice());
		Payment resultPayment = paymentProxy.pay(payment);
		
		if(resultPayment.getSuccessed()) {
			order.setPurchased(true);
			System.out.println("Order: " + order.toString());
			
			orderRepository.save(order);
			
		}
		System.err.println("결제 실패 ");
//		order.setPurchased(true);
//		System.out.println("Order: " + order.toString());
//			
//		orderRepository.save(order);
	}
}
