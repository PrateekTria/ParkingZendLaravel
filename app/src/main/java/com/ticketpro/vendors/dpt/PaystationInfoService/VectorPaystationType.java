package com.ticketpro.vendors.dpt.PaystationInfoService;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import java.util.Hashtable;
import org.ksoap2.serialization.SoapObject;

import com.ticketpro.vendors.dpt.PaystationInfoService.PaystationType;

import java.util.Vector;

public class VectorPaystationType extends Vector<PaystationType> implements KvmSerializable {
    
    
    public VectorPaystationType(){}
    
    public VectorPaystationType(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject != null){
            int size = soapObject.getPropertyCount();
            for (int i0=0;i0<size;i0++){
                Object obj = soapObject.getProperty(i0);
                if (obj!=null && obj.getClass().equals(SoapObject.class)){
                    SoapObject j0 =(SoapObject) soapObject.getProperty(i0);
                    PaystationType j1= new PaystationType(j0);
                    add(j1);
                }
            }
        }
    }
    @Override
    public Object getProperty(int arg0) {
        return this.get(arg0);
    }
    
    @Override
    public int getPropertyCount() {
        return this.size();
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        info.name = "PaystationType";
        info.type = PaystationType.class;
    }
    
    public String getInnerText() {
        return null;
    }
    
    public void setInnerText(String s) {
    }
    
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}