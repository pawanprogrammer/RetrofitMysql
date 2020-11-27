package com.trishasofttech.retrofitmysql;

import com.google.gson.annotations.SerializedName;

public class SignUpResponse {

    private String name;
    private String mobile;

    public SignUpResponse(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
