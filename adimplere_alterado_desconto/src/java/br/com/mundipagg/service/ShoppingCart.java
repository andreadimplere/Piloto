/**
 * ShoppingCart.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.mundipagg.service;

public class ShoppingCart  implements java.io.Serializable {
    private java.lang.Integer freightCostInCents;

    private br.com.mundipagg.service.ShoppingCartItem[] shoppingCartItemCollection;

    public ShoppingCart() {
    }

    public ShoppingCart(
           java.lang.Integer freightCostInCents,
           br.com.mundipagg.service.ShoppingCartItem[] shoppingCartItemCollection) {
           this.freightCostInCents = freightCostInCents;
           this.shoppingCartItemCollection = shoppingCartItemCollection;
    }


    /**
     * Gets the freightCostInCents value for this ShoppingCart.
     * 
     * @return freightCostInCents
     */
    public java.lang.Integer getFreightCostInCents() {
        return freightCostInCents;
    }


    /**
     * Sets the freightCostInCents value for this ShoppingCart.
     * 
     * @param freightCostInCents
     */
    public void setFreightCostInCents(java.lang.Integer freightCostInCents) {
        this.freightCostInCents = freightCostInCents;
    }


    /**
     * Gets the shoppingCartItemCollection value for this ShoppingCart.
     * 
     * @return shoppingCartItemCollection
     */
    public br.com.mundipagg.service.ShoppingCartItem[] getShoppingCartItemCollection() {
        return shoppingCartItemCollection;
    }


    /**
     * Sets the shoppingCartItemCollection value for this ShoppingCart.
     * 
     * @param shoppingCartItemCollection
     */
    public void setShoppingCartItemCollection(br.com.mundipagg.service.ShoppingCartItem[] shoppingCartItemCollection) {
        this.shoppingCartItemCollection = shoppingCartItemCollection;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ShoppingCart)) return false;
        ShoppingCart other = (ShoppingCart) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.freightCostInCents==null && other.getFreightCostInCents()==null) || 
             (this.freightCostInCents!=null &&
              this.freightCostInCents.equals(other.getFreightCostInCents()))) &&
            ((this.shoppingCartItemCollection==null && other.getShoppingCartItemCollection()==null) || 
             (this.shoppingCartItemCollection!=null &&
              java.util.Arrays.equals(this.shoppingCartItemCollection, other.getShoppingCartItemCollection())));
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
        if (getFreightCostInCents() != null) {
            _hashCode += getFreightCostInCents().hashCode();
        }
        if (getShoppingCartItemCollection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getShoppingCartItemCollection());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getShoppingCartItemCollection(), i);
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
        new org.apache.axis.description.TypeDesc(ShoppingCart.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCart"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("freightCostInCents");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "FreightCostInCents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shoppingCartItemCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCartItemCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCartItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "ShoppingCartItem"));
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
