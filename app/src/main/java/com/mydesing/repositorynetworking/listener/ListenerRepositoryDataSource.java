package com.mydesing.repositorynetworking.listener;

import com.mydesing.repositorynetworking.model.Question;

import java.util.List;

public interface ListenerRepositoryDataSource {
    void sendDataToRepository(List<Question> questions);
}
