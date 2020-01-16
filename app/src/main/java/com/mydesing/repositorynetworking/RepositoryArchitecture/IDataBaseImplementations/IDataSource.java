package com.mydesing.repositorynetworking.RepositoryArchitecture.IDataBaseImplementations;

import com.mydesing.repositorynetworking.listener.CustomListenerRep;
import com.mydesing.repositorynetworking.listener.ListenerRepositoryDataSource;
import com.mydesing.repositorynetworking.model.Question;

import java.util.List;

public interface IDataSource {
    void getData(final ListenerRepositoryDataSource listenerRep);
    void insertData(List<Question> questionList);
}
