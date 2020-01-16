package com.mydesing.repositorynetworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mydesing.repositorynetworking.RepositoryArchitecture.RepositoryInstance;
import com.mydesing.repositorynetworking.RepositoryArchitecture.RepositoryQuestion.RepositoryQuestion;
import com.mydesing.repositorynetworking.RepositoryArchitecture.RepositoryQuestion.RepositoryQuestionImpl;
import com.mydesing.repositorynetworking.adapter.AdapterQuestions;
import com.mydesing.repositorynetworking.listener.CustomListenerRep;
import com.mydesing.repositorynetworking.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RepositoryQuestion repo= RepositoryInstance.repositoryQuestion(getApplicationContext());
        repo.getQuestions("10", null, null, null, new CustomListenerRep() {
            @Override
            public void RepReturn(List<Question> questions) {
                AdapterQuestions adapterQuestions=new AdapterQuestions(questions);
                recyclerView.setAdapter(adapterQuestions);
            }
        });
    }
}
