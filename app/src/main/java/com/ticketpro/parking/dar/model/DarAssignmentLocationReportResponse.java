package com.ticketpro.parking.dar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DarAssignmentLocationReportResponse {
    @SerializedName("result")
    @Expose
    private DarAssignmentLocationReportResponseResult result;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("jsonrpc")
    @Expose
    private String jsonrpc;

    public DarAssignmentLocationReportResponseResult getResult() {
        return result;
    }

    public void setResult(DarAssignmentLocationReportResponseResult result) {
        this.result = result;
    }

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
}