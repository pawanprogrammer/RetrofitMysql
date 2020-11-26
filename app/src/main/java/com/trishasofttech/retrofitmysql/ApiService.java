package com.trishasofttech.retrofitmysql;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded    // annotation that used with POST type request
    @POST("/calldir/registerrecord.php") // specify the sub url for our base url
    Call<SignUpResponse> createUser(
            @Field("namekey") String name,
            @Field("mobilekey") String mobile);
}
