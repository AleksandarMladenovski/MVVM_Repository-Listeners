package com.mydesing.repositorynetworking.RepositoryArchitecture.RepositoryQuestion;

import com.mydesing.repositorynetworking.listener.CustomListenerRep;
import com.mydesing.repositorynetworking.model.Question;

import java.util.ArrayList;

public interface RepositoryQuestion {
   void getQuestions(String amount, String category, String difficulty, String type, CustomListenerRep listenerRep);
}
