package com.ticketpro.parking.dar.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ticketpro.parking.dar.model.params.ParamFlayer;

public class FlayerJSON_rpc {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("jsonrpc")
    @Expose
    private String jsonrpc;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("params")
    @Expose
    private ParamFlayer params;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ParamFlayer getParams() {
        return params;
    }

    public void setParams(ParamFlayer params) {
        this.params = params;
    }

}