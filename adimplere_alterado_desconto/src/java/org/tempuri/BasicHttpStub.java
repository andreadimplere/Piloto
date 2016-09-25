/**
 * BasicHttpStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class BasicHttpStub extends org.apache.axis.client.Stub implements org.tempuri.MundiPaggService_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[5];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CreateOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "createOrderRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreateOrderRequest"), br.com.mundipagg.service.CreateOrderRequest.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreateOrderResponse"));
        oper.setReturnClass(br.com.mundipagg.service.CreateOrderResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "CreateOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ManageOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "manageOrderRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ManageOrderRequest"), br.com.mundipagg.service.ManageOrderRequest.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ManageOrderResponse"));
        oper.setReturnClass(br.com.mundipagg.service.ManageOrderResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ManageOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("QueryOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "queryOrderRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "QueryOrderRequest"), br.com.mundipagg.service.QueryOrderRequest.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "QueryOrderResponse"));
        oper.setReturnClass(br.com.mundipagg.service.QueryOrderResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "QueryOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetInstantBuyData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "queryCreditCardDataRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "GetInstantBuyDataRequest"), br.com.mundipagg.service.GetInstantBuyDataRequest.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "GetInstantBuyDataResponse"));
        oper.setReturnClass(br.com.mundipagg.service.GetInstantBuyDataResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetInstantBuyDataResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RetryOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "manualRetryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "RetryOrderRequest"), br.com.mundipagg.service.RetryOrderRequest.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "RetryOrderResponse"));
        oper.setReturnClass(br.com.mundipagg.service.RetryOrderResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "RetryOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

    }

    public BasicHttpStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BasicHttpStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BasicHttpStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", ">OriginalAcquirerReturn>OriginalAcquirerReturnItem");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.OriginalAcquirerReturnOriginalAcquirerReturnItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "AddressTypeEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.AddressTypeEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfBoletoTransaction");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.BoletoTransaction[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransaction");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransaction");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfBoletoTransactionData");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.BoletoTransactionData[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransactionData");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransactionData");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfBoletoTransactionResult");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.BoletoTransactionResult[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransactionResult");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransactionResult");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfBuyerAddress");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.BuyerAddress[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BuyerAddress");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BuyerAddress");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfCreditCardData");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreditCardData[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardData");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardData");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfCreditCardTransaction");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreditCardTransaction[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransaction");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransaction");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfCreditCardTransactionData");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreditCardTransactionData[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransactionData");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransactionData");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfCreditCardTransactionResult");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreditCardTransactionResult[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransactionResult");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransactionResult");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfErrorItem");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.ErrorItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ErrorItem");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ErrorItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfManageCreditCardTransactionRequest");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.ManageCreditCardTransactionRequest[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ManageCreditCardTransactionRequest");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ManageCreditCardTransactionRequest");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfOrderData");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.OrderData[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "OrderData");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "OrderData");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfRetryOrderCreditCardTransactionRequest");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.RetryOrderCreditCardTransactionRequest[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "RetryOrderCreditCardTransactionRequest");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "RetryOrderCreditCardTransactionRequest");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfShoppingCart");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.ShoppingCart[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCart");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCart");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ArrayOfShoppingCartItem");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.ShoppingCartItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCartItem");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCartItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransaction");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.BoletoTransaction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransactionData");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.BoletoTransactionData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransactionResult");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.BoletoTransactionResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransactionStatusEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.BoletoTransactionStatusEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "Buyer");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.Buyer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BuyerAddress");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.BuyerAddress.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CountryEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CountryEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreateOrderRequest");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreateOrderRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreateOrderResponse");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreateOrderResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardBrandEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreditCardBrandEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardData");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreditCardData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardOperationEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreditCardOperationEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransaction");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreditCardTransaction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransactionData");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreditCardTransactionData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransactionResult");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreditCardTransactionResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransactionStatusEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CreditCardTransactionStatusEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CurrencyIsoEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.CurrencyIsoEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "EmailUpdateToBuyerEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.EmailUpdateToBuyerEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ErrorItem");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.ErrorItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ErrorReport");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.ErrorReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "FrequencyEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.FrequencyEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "GenderEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.GenderEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "GetInstantBuyDataRequest");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.GetInstantBuyDataRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "GetInstantBuyDataResponse");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.GetInstantBuyDataResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ManageCreditCardTransactionRequest");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.ManageCreditCardTransactionRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ManageOrderOperationEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.ManageOrderOperationEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ManageOrderRequest");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.ManageOrderRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ManageOrderResponse");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.ManageOrderResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "MundiPaggSuggestion");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.MundiPaggSuggestion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "OrderData");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.OrderData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "OrderStatusEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.OrderStatusEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "OriginalAcquirerReturn");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.OriginalAcquirerReturnOriginalAcquirerReturnItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", ">OriginalAcquirerReturn>OriginalAcquirerReturnItem");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "OriginalAcquirerReturnItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "PersonTypeEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.PersonTypeEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "QueryOrderRequest");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.QueryOrderRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "QueryOrderResponse");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.QueryOrderResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "Recurrency");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.Recurrency.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "RetryOrderCreditCardTransactionRequest");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.RetryOrderCreditCardTransactionRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "RetryOrderRequest");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.RetryOrderRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "RetryOrderResponse");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.RetryOrderResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "SeverityCodeEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.SeverityCodeEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCart");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.ShoppingCart.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCartItem");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.ShoppingCartItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "TaxDocumentTypeEnum");
            cachedSerQNames.add(qName);
            cls = br.com.mundipagg.service.TaxDocumentTypeEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public br.com.mundipagg.service.CreateOrderResponse createOrder(br.com.mundipagg.service.CreateOrderRequest createOrderRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/MundiPaggService/CreateOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "CreateOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {createOrderRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.com.mundipagg.service.CreateOrderResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.com.mundipagg.service.CreateOrderResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.com.mundipagg.service.CreateOrderResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.com.mundipagg.service.ManageOrderResponse manageOrder(br.com.mundipagg.service.ManageOrderRequest manageOrderRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/MundiPaggService/ManageOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ManageOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {manageOrderRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.com.mundipagg.service.ManageOrderResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.com.mundipagg.service.ManageOrderResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.com.mundipagg.service.ManageOrderResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.com.mundipagg.service.QueryOrderResponse queryOrder(br.com.mundipagg.service.QueryOrderRequest queryOrderRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/MundiPaggService/QueryOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "QueryOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {queryOrderRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.com.mundipagg.service.QueryOrderResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.com.mundipagg.service.QueryOrderResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.com.mundipagg.service.QueryOrderResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.com.mundipagg.service.GetInstantBuyDataResponse getInstantBuyData(br.com.mundipagg.service.GetInstantBuyDataRequest queryCreditCardDataRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/MundiPaggService/GetInstantBuyData");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetInstantBuyData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {queryCreditCardDataRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.com.mundipagg.service.GetInstantBuyDataResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.com.mundipagg.service.GetInstantBuyDataResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.com.mundipagg.service.GetInstantBuyDataResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.com.mundipagg.service.RetryOrderResponse retryOrder(br.com.mundipagg.service.RetryOrderRequest manualRetryRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/MundiPaggService/RetryOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "RetryOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {manualRetryRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.com.mundipagg.service.RetryOrderResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.com.mundipagg.service.RetryOrderResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.com.mundipagg.service.RetryOrderResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
