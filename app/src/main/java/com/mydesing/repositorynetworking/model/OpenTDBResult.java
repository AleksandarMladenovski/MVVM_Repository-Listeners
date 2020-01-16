package com.mydesing.repositorynetworking.model;

import java.util.ArrayList;

public class OpenTDBResult {
    private ArrayList<Question>results;

    public  OpenTDBResult(){

    }
    public OpenTDBResult(ArrayList<Question> results) {
        this.results = results;
    }

    public ArrayList<Question> getQuestions() {
        return results;
    }

    public void setQuestions(ArrayList<Question> results) {
        this.results = results;
    }
}
