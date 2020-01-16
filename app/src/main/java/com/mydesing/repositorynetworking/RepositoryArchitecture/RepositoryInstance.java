package com.mydesing.repositorynetworking.RepositoryArchitecture;

import android.content.Context;

import com.mydesing.repositorynetworking.RepositoryArchitecture.IDataBaseImplementations.DatabaseDataSource;
import com.mydesing.repositorynetworking.RepositoryArchitecture.IDataBaseImplementations.IDataSource;
import com.mydesing.repositorynetworking.RepositoryArchitecture.IDataBaseImplementations.NetworkDataSource;
import com.mydesing.repositorynetworking.RepositoryArchitecture.RepositoryQuestion.RepositoryQuestionImpl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryInstance {
   private static RepositoryQuestionImpl repositoryQuestion;

    public static RepositoryQuestionImpl repositoryQuestion(Context context){
        if(repositoryQuestion!=null){
            return repositoryQuestion;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://opentdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IDataSource database=new DatabaseDataSource(context);
        IDataSource network = new NetworkDataSource(retrofit);
        repositoryQuestion=new RepositoryQuestionImpl(network, database);

        return repositoryQuestion;
    }
}
