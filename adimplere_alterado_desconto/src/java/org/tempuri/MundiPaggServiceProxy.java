package org.tempuri;

public class MundiPaggServiceProxy implements org.tempuri.MundiPaggService_PortType {
  private String _endpoint = null;
  private org.tempuri.MundiPaggService_PortType mundiPaggService_PortType = null;
  
  public MundiPaggServiceProxy() {
    _initMundiPaggServiceProxy();
  }
  
  public MundiPaggServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initMundiPaggServiceProxy();
  }
  
  private void _initMundiPaggServiceProxy() {
    try {
      mundiPaggService_PortType = (new org.tempuri.MundiPaggService_ServiceLocator()).getbasicHttp();
      if (mundiPaggService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mundiPaggService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mundiPaggService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mundiPaggService_PortType != null)
      ((javax.xml.rpc.Stub)mundiPaggService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.MundiPaggService_PortType getMundiPaggService_PortType() {
    if (mundiPaggService_PortType == null)
      _initMundiPaggServiceProxy();
    return mundiPaggService_PortType;
  }
  
  public br.com.mundipagg.service.CreateOrderResponse createOrder(br.com.mundipagg.service.CreateOrderRequest createOrderRequest) throws java.rmi.RemoteException{
    if (mundiPaggService_PortType == null)
      _initMundiPaggServiceProxy();
    return mundiPaggService_PortType.createOrder(createOrderRequest);
  }
  
  public br.com.mundipagg.service.ManageOrderResponse manageOrder(br.com.mundipagg.service.ManageOrderRequest manageOrderRequest) throws java.rmi.RemoteException{
    if (mundiPaggService_PortType == null)
      _initMundiPaggServiceProxy();
    return mundiPaggService_PortType.manageOrder(manageOrderRequest);
  }
  
  public br.com.mundipagg.service.QueryOrderResponse queryOrder(br.com.mundipagg.service.QueryOrderRequest queryOrderRequest) throws java.rmi.RemoteException{
    if (mundiPaggService_PortType == null)
      _initMundiPaggServiceProxy();
    return mundiPaggService_PortType.queryOrder(queryOrderRequest);
  }
  
  public br.com.mundipagg.service.GetInstantBuyDataResponse getInstantBuyData(br.com.mundipagg.service.GetInstantBuyDataRequest queryCreditCardDataRequest) throws java.rmi.RemoteException{
    if (mundiPaggService_PortType == null)
      _initMundiPaggServiceProxy();
    return mundiPaggService_PortType.getInstantBuyData(queryCreditCardDataRequest);
  }
  
  public br.com.mundipagg.service.RetryOrderResponse retryOrder(br.com.mundipagg.service.RetryOrderRequest manualRetryRequest) throws java.rmi.RemoteException{
    if (mundiPaggService_PortType == null)
      _initMundiPaggServiceProxy();
    return mundiPaggService_PortType.retryOrder(manualRetryRequest);
  }
  
  
}