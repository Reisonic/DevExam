package io.reisonic.devs.Presenter.NetworkInterface;

import io.reisonic.devs.Model.RetrofitData.BoolRequest;
import io.reisonic.devs.Model.RetrofitData.Phone;
import io.reisonic.devs.Model.RetrofitData.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface RetrofitAPI {
    @GET("/api/v1/posts")
    Call<List<Post>> getPosts();

    @GET("/api/v1/phone_masks")
    Call<Phone> getPhone();

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/api/v1/auth")
    Call<BoolRequest> getPosts(@QueryMap Map<String, String> parameters);
}

