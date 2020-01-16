package com.mydesing.repositorynetworking.RepositoryArchitecture.IDataBaseImplementations;

import android.content.Context;
import android.util.Log;

import com.mydesing.repositorynetworking.RepositoryArchitecture.DataBase.AppSingleton;
import com.mydesing.repositorynetworking.RepositoryArchitecture.DataBase.DataBaseHelper;
import com.mydesing.repositorynetworking.listener.CustomListenerRep;
import com.mydesing.repositorynetworking.listener.ListenerRepositoryDataSource;
import com.mydesing.repositorynetworking.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDataSource implements IDataSource {
    private Context context;

    public DatabaseDataSource(Context context) {
    this.context=context;
    }

    public DatabaseDataSource() {
    }

    @Override
    public void getData(ListenerRepositoryDataSource listenerRep) {
     DataBaseHelper db= AppSingleton.getINSTANCE(context).getDbHelper();
     List<Question>questions=db.getAllQuestions();
        Log.e("DATABASE_QUESTION_COUNT",String.valueOf(questions.size()));
     listenerRep.sendDataToRepository(questions);
        db.close();
    }

    @Override
    public void insertData(List<Question> questionList) {
        DataBaseHelper db= AppSingleton.getINSTANCE(context).getDbHelper();
            for(Question question:questionList){
                db.insertQuestion(question);
            }
            db.close();
    }
}
