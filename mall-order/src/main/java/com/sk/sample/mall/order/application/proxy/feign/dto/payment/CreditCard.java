package com.sk.sample.mall.order.application.proxy.feign.dto.payment;



import lombok.Data;

@Data
public class CreditCard {
	private String cardNumber;
	private String validThru;
	
	public CreditCard(String cardNumber, String validThru) {
		this.cardNumber = cardNumber;
		this.validThru = validThru;
	}
}
