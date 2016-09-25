/**
 * CreateOrderRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.mundipagg.service;

public class CreateOrderRequest  implements java.io.Serializable {
    private java.lang.Long amountInCents;

    private java.lang.Long amountInCentsToConsiderPaid;

    private br.com.mundipagg.service.CurrencyIsoEnum currencyIsoEnum;

    private br.com.mundipagg.service.EmailUpdateToBuyerEnum emailUpdateToBuyerEnum;

    private java.lang.String merchantKey;

    private java.lang.String orderReference;

    private java.lang.String requestKey;

    private java.lang.Integer retries;

    private br.com.mundipagg.service.Buyer buyer;

    private br.com.mundipagg.service.ShoppingCart[] shoppingCartCollection;

    private br.com.mundipagg.service.CreditCardTransaction[] creditCardTransactionCollection;

    private br.com.mundipagg.service.BoletoTransaction[] boletoTransactionCollection;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(
           java.lang.Long amountInCents,
           java.lang.Long amountInCentsToConsiderPaid,
           br.com.mundipagg.service.CurrencyIsoEnum currencyIsoEnum,
           br.com.mundipagg.service.EmailUpdateToBuyerEnum emailUpdateToBuyerEnum,
           java.lang.String merchantKey,
           java.lang.String orderReference,
           java.lang.String requestKey,
           java.lang.Integer retries,
           br.com.mundipagg.service.Buyer buyer,
           br.com.mundipagg.service.ShoppingCart[] shoppingCartCollection,
           br.com.mundipagg.service.CreditCardTransaction[] creditCardTransactionCollection,
           br.com.mundipagg.service.BoletoTransaction[] boletoTransactionCollection) {
           this.amountInCents = amountInCents;
           this.amountInCentsToConsiderPaid = amountInCentsToConsiderPaid;
           this.currencyIsoEnum = currencyIsoEnum;
           this.emailUpdateToBuyerEnum = emailUpdateToBuyerEnum;
           this.merchantKey = merchantKey;
           this.orderReference = orderReference;
           this.requestKey = requestKey;
           this.retries = retries;
           this.buyer = buyer;
           this.shoppingCartCollection = shoppingCartCollection;
           this.creditCardTransactionCollection = creditCardTransactionCollection;
           this.boletoTransactionCollection = boletoTransactionCollection;
    }


    /**
     * Gets the amountInCents value for this CreateOrderRequest.
     * 
     * @return amountInCents
     */
    public java.lang.Long getAmountInCents() {
        return amountInCents;
    }


    /**
     * Sets the amountInCents value for this CreateOrderRequest.
     * 
     * @param amountInCents
     */
    public void setAmountInCents(java.lang.Long amountInCents) {
        this.amountInCents = amountInCents;
    }


    /**
     * Gets the amountInCentsToConsiderPaid value for this CreateOrderRequest.
     * 
     * @return amountInCentsToConsiderPaid
     */
    public java.lang.Long getAmountInCentsToConsiderPaid() {
        return amountInCentsToConsiderPaid;
    }


    /**
     * Sets the amountInCentsToConsiderPaid value for this CreateOrderRequest.
     * 
     * @param amountInCentsToConsiderPaid
     */
    public void setAmountInCentsToConsiderPaid(java.lang.Long amountInCentsToConsiderPaid) {
        this.amountInCentsToConsiderPaid = amountInCentsToConsiderPaid;
    }


    /**
     * Gets the currencyIsoEnum value for this CreateOrderRequest.
     * 
     * @return currencyIsoEnum
     */
    public br.com.mundipagg.service.CurrencyIsoEnum getCurrencyIsoEnum() {
        return currencyIsoEnum;
    }


    /**
     * Sets the currencyIsoEnum value for this CreateOrderRequest.
     * 
     * @param currencyIsoEnum
     */
    public void setCurrencyIsoEnum(br.com.mundipagg.service.CurrencyIsoEnum currencyIsoEnum) {
        this.currencyIsoEnum = currencyIsoEnum;
    }


    /**
     * Gets the emailUpdateToBuyerEnum value for this CreateOrderRequest.
     * 
     * @return emailUpdateToBuyerEnum
     */
    public br.com.mundipagg.service.EmailUpdateToBuyerEnum getEmailUpdateToBuyerEnum() {
        return emailUpdateToBuyerEnum;
    }


    /**
     * Sets the emailUpdateToBuyerEnum value for this CreateOrderRequest.
     * 
     * @param emailUpdateToBuyerEnum
     */
    public void setEmailUpdateToBuyerEnum(br.com.mundipagg.service.EmailUpdateToBuyerEnum emailUpdateToBuyerEnum) {
        this.emailUpdateToBuyerEnum = emailUpdateToBuyerEnum;
    }


    /**
     * Gets the merchantKey value for this CreateOrderRequest.
     * 
     * @return merchantKey
     */
    public java.lang.String getMerchantKey() {
        return merchantKey;
    }


    /**
     * Sets the merchantKey value for this CreateOrderRequest.
     * 
     * @param merchantKey
     */
    public void setMerchantKey(java.lang.String merchantKey) {
        this.merchantKey = merchantKey;
    }


    /**
     * Gets the orderReference value for this CreateOrderRequest.
     * 
     * @return orderReference
     */
    public java.lang.String getOrderReference() {
        return orderReference;
    }


    /**
     * Sets the orderReference value for this CreateOrderRequest.
     * 
     * @param orderReference
     */
    public void setOrderReference(java.lang.String orderReference) {
        this.orderReference = orderReference;
    }


    /**
     * Gets the requestKey value for this CreateOrderRequest.
     * 
     * @return requestKey
     */
    public java.lang.String getRequestKey() {
        return requestKey;
    }


    /**
     * Sets the requestKey value for this CreateOrderRequest.
     * 
     * @param requestKey
     */
    public void setRequestKey(java.lang.String requestKey) {
        this.requestKey = requestKey;
    }


    /**
     * Gets the retries value for this CreateOrderRequest.
     * 
     * @return retries
     */
    public java.lang.Integer getRetries() {
        return retries;
    }


    /**
     * Sets the retries value for this CreateOrderRequest.
     * 
     * @param retries
     */
    public void setRetries(java.lang.Integer retries) {
        this.retries = retries;
    }


    /**
     * Gets the buyer value for this CreateOrderRequest.
     * 
     * @return buyer
     */
    public br.com.mundipagg.service.Buyer getBuyer() {
        return buyer;
    }


    /**
     * Sets the buyer value for this CreateOrderRequest.
     * 
     * @param buyer
     */
    public void setBuyer(br.com.mundipagg.service.Buyer buyer) {
        this.buyer = buyer;
    }


    /**
     * Gets the shoppingCartCollection value for this CreateOrderRequest.
     * 
     * @return shoppingCartCollection
     */
    public br.com.mundipagg.service.ShoppingCart[] getShoppingCartCollection() {
        return shoppingCartCollection;
    }


    /**
     * Sets the shoppingCartCollection value for this CreateOrderRequest.
     * 
     * @param shoppingCartCollection
     */
    public void setShoppingCartCollection(br.com.mundipagg.service.ShoppingCart[] shoppingCartCollection) {
        this.shoppingCartCollection = shoppingCartCollection;
    }


    /**
     * Gets the creditCardTransactionCollection value for this CreateOrderRequest.
     * 
     * @return creditCardTransactionCollection
     */
    public br.com.mundipagg.service.CreditCardTransaction[] getCreditCardTransactionCollection() {
        return creditCardTransactionCollection;
    }


    /**
     * Sets the creditCardTransactionCollection value for this CreateOrderRequest.
     * 
     * @param creditCardTransactionCollection
     */
    public void setCreditCardTransactionCollection(br.com.mundipagg.service.CreditCardTransaction[] creditCardTransactionCollection) {
        this.creditCardTransactionCollection = creditCardTransactionCollection;
    }


    /**
     * Gets the boletoTransactionCollection value for this CreateOrderRequest.
     * 
     * @return boletoTransactionCollection
     */
    public br.com.mundipagg.service.BoletoTransaction[] getBoletoTransactionCollection() {
        return boletoTransactionCollection;
    }


    /**
     * Sets the boletoTransactionCollection value for this CreateOrderRequest.
     * 
     * @param boletoTransactionCollection
     */
    public void setBoletoTransactionCollection(br.com.mundipagg.service.BoletoTransaction[] boletoTransactionCollection) {
        this.boletoTransactionCollection = boletoTransactionCollection;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateOrderRequest)) return false;
        CreateOrderRequest other = (CreateOrderRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.amountInCents==null && other.getAmountInCents()==null) || 
             (this.amountInCents!=null &&
              this.amountInCents.equals(other.getAmountInCents()))) &&
            ((this.amountInCentsToConsiderPaid==null && other.getAmountInCentsToConsiderPaid()==null) || 
             (this.amountInCentsToConsiderPaid!=null &&
              this.amountInCentsToConsiderPaid.equals(other.getAmountInCentsToConsiderPaid()))) &&
            ((this.currencyIsoEnum==null && other.getCurrencyIsoEnum()==null) || 
             (this.currencyIsoEnum!=null &&
              this.currencyIsoEnum.equals(other.getCurrencyIsoEnum()))) &&
            ((this.emailUpdateToBuyerEnum==null && other.getEmailUpdateToBuyerEnum()==null) || 
             (this.emailUpdateToBuyerEnum!=null &&
              this.emailUpdateToBuyerEnum.equals(other.getEmailUpdateToBuyerEnum()))) &&
            ((this.merchantKey==null && other.getMerchantKey()==null) || 
             (this.merchantKey!=null &&
              this.merchantKey.equals(other.getMerchantKey()))) &&
            ((this.orderReference==null && other.getOrderReference()==null) || 
             (this.orderReference!=null &&
              this.orderReference.equals(other.getOrderReference()))) &&
            ((this.requestKey==null && other.getRequestKey()==null) || 
             (this.requestKey!=null &&
              this.requestKey.equals(other.getRequestKey()))) &&
            ((this.retries==null && other.getRetries()==null) || 
             (this.retries!=null &&
              this.retries.equals(other.getRetries()))) &&
            ((this.buyer==null && other.getBuyer()==null) || 
             (this.buyer!=null &&
              this.buyer.equals(other.getBuyer()))) &&
            ((this.shoppingCartCollection==null && other.getShoppingCartCollection()==null) || 
             (this.shoppingCartCollection!=null &&
              java.util.Arrays.equals(this.shoppingCartCollection, other.getShoppingCartCollection()))) &&
            ((this.creditCardTransactionCollection==null && other.getCreditCardTransactionCollection()==null) || 
             (this.creditCardTransactionCollection!=null &&
              java.util.Arrays.equals(this.creditCardTransactionCollection, other.getCreditCardTransactionCollection()))) &&
            ((this.boletoTransactionCollection==null && other.getBoletoTransactionCollection()==null) || 
             (this.boletoTransactionCollection!=null &&
              java.util.Arrays.equals(this.boletoTransactionCollection, other.getBoletoTransactionCollection())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAmountInCents() != null) {
            _hashCode += getAmountInCents().hashCode();
        }
        if (getAmountInCentsToConsiderPaid() != null) {
            _hashCode += getAmountInCentsToConsiderPaid().hashCode();
        }
        if (getCurrencyIsoEnum() != null) {
            _hashCode += getCurrencyIsoEnum().hashCode();
        }
        if (getEmailUpdateToBuyerEnum() != null) {
            _hashCode += getEmailUpdateToBuyerEnum().hashCode();
        }
        if (getMerchantKey() != null) {
            _hashCode += getMerchantKey().hashCode();
        }
        if (getOrderReference() != null) {
            _hashCode += getOrderReference().hashCode();
        }
        if (getRequestKey() != null) {
            _hashCode += getRequestKey().hashCode();
        }
        if (getRetries() != null) {
            _hashCode += getRetries().hashCode();
        }
        if (getBuyer() != null) {
            _hashCode += getBuyer().hashCode();
        }
        if (getShoppingCartCollection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getShoppingCartCollection());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getShoppingCartCollection(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCreditCardTransactionCollection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCreditCardTransactionCollection());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCreditCardTransactionCollection(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBoletoTransactionCollection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBoletoTransactionCollection());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBoletoTransactionCollection(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateOrderRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreateOrderRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amountInCents");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "AmountInCents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amountInCentsToConsiderPaid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "AmountInCentsToConsiderPaid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyIsoEnum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CurrencyIsoEnum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CurrencyIsoEnum"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailUpdateToBuyerEnum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "EmailUpdateToBuyerEnum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "EmailUpdateToBuyerEnum"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchantKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "MerchantKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderReference");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "OrderReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "RequestKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retries");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "Retries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("buyer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "Buyer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "Buyer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shoppingCartCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCartCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCart"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCart"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditCardTransactionCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransactionCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransaction"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "CreditCardTransaction"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boletoTransactionCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransactionCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransaction"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransaction"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
