package br.com.mundipagg.client;

import br.com.mundipagg.service.CreateOrderRequest;

public class CreateOrderValidationRules {

	
	
	public static boolean existTransactionInCollection(CreateOrderRequest request){
		
		boolean result = false;
		
		if ((request.getBoletoTransactionCollection() != null && request.getBoletoTransactionCollection().length > 0) ||
		(request.getCreditCardTransactionCollection() != null && request.getCreditCardTransactionCollection().length > 0)){
			result = true;
		}
		return result;
	}
}
