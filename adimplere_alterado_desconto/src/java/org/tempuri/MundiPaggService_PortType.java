/**
 * MundiPaggService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface MundiPaggService_PortType extends java.rmi.Remote {
    public br.com.mundipagg.service.CreateOrderResponse createOrder(br.com.mundipagg.service.CreateOrderRequest createOrderRequest) throws java.rmi.RemoteException;
    public br.com.mundipagg.service.ManageOrderResponse manageOrder(br.com.mundipagg.service.ManageOrderRequest manageOrderRequest) throws java.rmi.RemoteException;
    public br.com.mundipagg.service.QueryOrderResponse queryOrder(br.com.mundipagg.service.QueryOrderRequest queryOrderRequest) throws java.rmi.RemoteException;
    public br.com.mundipagg.service.GetInstantBuyDataResponse getInstantBuyData(br.com.mundipagg.service.GetInstantBuyDataRequest queryCreditCardDataRequest) throws java.rmi.RemoteException;
    public br.com.mundipagg.service.RetryOrderResponse retryOrder(br.com.mundipagg.service.RetryOrderRequest manualRetryRequest) throws java.rmi.RemoteException;
}
