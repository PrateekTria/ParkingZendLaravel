package com.ticketpro.parking.syncreport.responsemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("serviceError")
    @Expose
    private String serviceError;
    @SerializedName("msg")
    @Expose
    private Boolean msg;

    public String getServiceError() {
        return serviceError;
    }

    public void setServiceError(String serviceError) {
        this.serviceError = serviceError;
    }

    public Boolean getMsg() {
        return msg;
    }

    public void setMsg(Boolean msg) {
        this.msg = msg;
    }
}