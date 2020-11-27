package com.trishasofttech.retrofitmysql.DataFetch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "http://searchkero.com/";
    @GET("/calldir/showrecord.php")
    Call<List<Details_Pojo>> getstatus();
}
