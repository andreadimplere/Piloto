/**
 * BoletoTransactionStatusEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.mundipagg.service;

public class BoletoTransactionStatusEnum implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected BoletoTransactionStatusEnum(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Generated = "Generated";
    public static final java.lang.String _Viewed = "Viewed";
    public static final java.lang.String _Underpaid = "Underpaid";
    public static final java.lang.String _Overpaid = "Overpaid";
    public static final java.lang.String _Paid = "Paid";
    public static final java.lang.String _Voided = "Voided";
    public static final java.lang.String _WithError = "WithError";
    public static final BoletoTransactionStatusEnum Generated = new BoletoTransactionStatusEnum(_Generated);
    public static final BoletoTransactionStatusEnum Viewed = new BoletoTransactionStatusEnum(_Viewed);
    public static final BoletoTransactionStatusEnum Underpaid = new BoletoTransactionStatusEnum(_Underpaid);
    public static final BoletoTransactionStatusEnum Overpaid = new BoletoTransactionStatusEnum(_Overpaid);
    public static final BoletoTransactionStatusEnum Paid = new BoletoTransactionStatusEnum(_Paid);
    public static final BoletoTransactionStatusEnum Voided = new BoletoTransactionStatusEnum(_Voided);
    public static final BoletoTransactionStatusEnum WithError = new BoletoTransactionStatusEnum(_WithError);
    public java.lang.String getValue() { return _value_;}
    public static BoletoTransactionStatusEnum fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        BoletoTransactionStatusEnum enumeration = (BoletoTransactionStatusEnum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static BoletoTransactionStatusEnum fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BoletoTransactionStatusEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/MundiPagg.One.Service.DataContracts", "BoletoTransactionStatusEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
