package com.mydesing.repositorynetworking.RetrofitImplementation;

import com.mydesing.repositorynetworking.model.OpenTDBResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetRetrofitDataService {
       @GET("api.php")
       Call<OpenTDBResult> get_Trivia_Questions(@Query("amount") String amount, @Query("category") String category, @Query("difficulty") String difficulty, @Query("type") String type);
}
