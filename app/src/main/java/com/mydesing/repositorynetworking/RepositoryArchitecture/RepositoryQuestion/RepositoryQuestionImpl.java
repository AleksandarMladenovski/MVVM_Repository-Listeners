package com.mydesing.repositorynetworking.RepositoryArchitecture.RepositoryQuestion;

import android.util.Log;

import com.mydesing.repositorynetworking.RepositoryArchitecture.IDataBaseImplementations.IDataSource;
import com.mydesing.repositorynetworking.listener.CustomListenerRep;
import com.mydesing.repositorynetworking.listener.ListenerRepositoryDataSource;
import com.mydesing.repositorynetworking.model.Question;

import java.util.ArrayList;
import java.util.List;

public class RepositoryQuestionImpl implements RepositoryQuestion {
    private IDataSource networkDataSource;
    private IDataSource databaseDataSource;

    public RepositoryQuestionImpl(IDataSource networkDataSource, IDataSource databaseDataSource) {
        this.networkDataSource = networkDataSource;
        this.databaseDataSource = databaseDataSource;
    }

    @Override
    public void getQuestions(String amount, String category, String difficulty, String type, final CustomListenerRep listenerRep) {

        networkDataSource.getData(new ListenerRepositoryDataSource() {
            @Override
            public void sendDataToRepository(List<Question> questions) {
                if (questions == null) {
                    databaseDataSource.getData(new ListenerRepositoryDataSource() {
                        @Override
                        public void sendDataToRepository(List<Question> questions) {
                            if (questions == null) {
                                Log.e("dataBaseEmpty","empty");

                            } else {
                                listenerRep.RepReturn(questions);
                            }
                        }
                    });
                }
                else {
                    databaseDataSource.insertData(questions);
                    listenerRep.RepReturn(questions);
                }
            }
        });
    }
}
