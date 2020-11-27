package com.trishasofttech.retrofitmysql.DataFetch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Details_Pojo {

    @SerializedName("name")
    @Expose
    private String Name;
    @SerializedName("mobile")
    @Expose
    private String Mobile;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
}
