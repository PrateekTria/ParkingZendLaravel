package com.ticketpro.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EulaReuest_Rpc {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("params")
    @Expose
    private EulaParams params;
    @SerializedName("jsonrpc")
    @Expose
    private String jsonrpc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public EulaParams getParams() {
        return params;
    }

    public void setParams(EulaParams params) {
        this.params = params;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

}