package com.mydesing.repositorynetworking.RepositoryArchitecture.IDataBaseImplementations;

import com.mydesing.repositorynetworking.RetrofitImplementation.GetRetrofitDataService;
import com.mydesing.repositorynetworking.RetrofitImplementation.RetrofitClientInstance;
import com.mydesing.repositorynetworking.listener.CustomListenerRep;
import com.mydesing.repositorynetworking.listener.ListenerRepositoryDataSource;
import com.mydesing.repositorynetworking.model.OpenTDBResult;
import com.mydesing.repositorynetworking.model.Question;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkDataSource implements IDataSource {
    private static GetRetrofitDataService dataServicee;

    public NetworkDataSource(Retrofit retrofit) {
        if (dataServicee == null) {
            dataServicee = retrofit.create(GetRetrofitDataService.class);
        }

    }

    public void getData(final ListenerRepositoryDataSource listenerRep) {


        Call<OpenTDBResult> call = dataServicee.get_Trivia_Questions("10", null, null, null);
        call.enqueue(new Callback<OpenTDBResult>() {
            @Override
            public void onResponse(Call<OpenTDBResult> call, Response<OpenTDBResult> response) {
                listenerRep.sendDataToRepository(response.body().getQuestions());
            }

            @Override
            public void onFailure(Call<OpenTDBResult> call, Throwable t) {
                listenerRep.sendDataToRepository(null);
            }
        });

    }

    @Override
    public void insertData(List<Question> questionList) {
        //TODO MAYBE POST METHOD
    }
}
