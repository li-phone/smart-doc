package com.power.doc.api.demo;

public class SubDemoObject {

    private String ts;
    private String token;
    private String reqId;
    private SubSubDemoObject subSubDemoObject;

    public SubSubDemoObject getSubSubDemoObject() {
        return subSubDemoObject;
    }

    public void setSubSubDemoObject(SubSubDemoObject subSubDemoObject) {
        this.subSubDemoObject = subSubDemoObject;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }
}
