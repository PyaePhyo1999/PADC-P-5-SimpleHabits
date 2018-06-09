package com.example.acer.simplehabit.network;

import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.events.CategoryProgramEvent;
import com.example.acer.simplehabit.events.CurrentProgramEvent;
import com.example.acer.simplehabit.events.TopicsEvent;
import com.example.acer.simplehabit.network.responses.GetCategoryResponse;
import com.example.acer.simplehabit.network.responses.GetCurrentProgramResponse;
import com.example.acer.simplehabit.network.responses.GetTopicsResponse;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Acer on 5/24/2018.
 */

public class SimpleHabitRetrofitDataAgent implements SimpleHabitDataAgent {
    private static SimpleHabitRetrofitDataAgent sObjectInstance;
    private SimpleHabitApi theApi;

    public static SimpleHabitRetrofitDataAgent getsObjectInstance() {
        if (sObjectInstance == null) {
            sObjectInstance = new SimpleHabitRetrofitDataAgent();
        }
        return sObjectInstance;
    }

    private SimpleHabitRetrofitDataAgent() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();
        theApi = retrofit.create(SimpleHabitApi.class);
    }


    @Override
    public void onLoadTopics() {
        Call<GetTopicsResponse> getTopicsResponse = theApi.loadTopicResponse("b002c7e1a528b7cb460933fc2875e916", 1);
        getTopicsResponse.enqueue(new Callback<GetTopicsResponse>() {
            @Override
            public void onResponse(Call<GetTopicsResponse> call, Response<GetTopicsResponse> response) {
                GetTopicsResponse topicsResponse = response.body();
                if (topicsResponse != null) {
                    TopicsEvent topicsEvent = new TopicsEvent(topicsResponse.getTopics());
                    EventBus.getDefault().post(topicsEvent);
                }
            }

            @Override
            public void onFailure(Call<GetTopicsResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void onLoadCurrentProgram() {
        Call<GetCurrentProgramResponse> getCurrentProgramResponse = theApi.loadCurrentProgramResponse("b002c7e1a528b7cb460933fc2875e916", 1);
        getCurrentProgramResponse.enqueue(new Callback<GetCurrentProgramResponse>() {
            @Override
            public void onResponse(Call<GetCurrentProgramResponse> call, Response<GetCurrentProgramResponse> response) {
                GetCurrentProgramResponse currentProgramResponse = response.body();
                if (currentProgramResponse != null) {
                    CurrentProgramEvent event = new CurrentProgramEvent( currentProgramResponse.getCurrentProgram());
                    EventBus.getDefault().post(event);
                }

            }

            @Override
            public void onFailure(Call<GetCurrentProgramResponse> call, Throwable t) {

            }
        });


    }

    @Override
    public void onLoadCategoryProgram() {
        Call<GetCategoryResponse> getCategoryResponse = theApi.loadCategoryProgramResponse("b002c7e1a528b7cb460933fc2875e916",1);
        getCategoryResponse.enqueue(new Callback<GetCategoryResponse>() {
            @Override
            public void onResponse(Call<GetCategoryResponse> call, Response<GetCategoryResponse> response) {
                GetCategoryResponse categoryResponse = response.body();
                if (categoryResponse!=null){
                    CategoryProgramEvent event = new CategoryProgramEvent(categoryResponse.getCategoriesPrograms());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetCategoryResponse> call, Throwable t) {

            }
        });
    }
}


