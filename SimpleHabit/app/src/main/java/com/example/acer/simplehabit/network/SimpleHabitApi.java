package com.example.acer.simplehabit.network;

import com.example.acer.simplehabit.network.responses.GetCategoryResponse;
import com.example.acer.simplehabit.network.responses.GetCurrentProgramResponse;
import com.example.acer.simplehabit.network.responses.GetTopicsResponse;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Acer on 5/24/2018.
 */

public interface SimpleHabitApi {
    @FormUrlEncoded
    @POST("getTopics.php")
    Call<GetTopicsResponse> loadTopicResponse(@Field("access_token")String accToken,
                                         @Field("page")int page  ) ;

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<GetCurrentProgramResponse> loadCurrentProgramResponse(@Field("access_token") String accessToken,
                                                               @Field("page") int page);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<GetCategoryResponse> loadCategoryProgramResponse(@Field("access_token") String accessToken,
                                                          @Field("page") int page);
}
