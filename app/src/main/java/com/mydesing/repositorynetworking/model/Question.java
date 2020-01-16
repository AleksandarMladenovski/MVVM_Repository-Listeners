package com.mydesing.repositorynetworking.model;

import java.util.ArrayList;

public class Question {
    private String category;
    private String difficulty;
    private String question;
    private String correct_answer;
    private ArrayList<String> incorrect_answers;
    private Integer id;
    public static final String TABLE_NAME="notes";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_CATEGORY="category";
    public static final String COLUMN_DIFFICULTY="description";
    public static final String COLUMN_QUESTION="question";
    public static final String COLUMN_CORRECT_ANSWER="correct_answer";
    public static final String COLUMN_INCORRECT_ANSWERS="incorrect_answers";
    public static final String
            CREATE_TABLE="CREATE TABLE "+TABLE_NAME +"("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_CATEGORY+" TEXT,"
            + COLUMN_DIFFICULTY+" TEXT,"
            + COLUMN_QUESTION+" TEXT,"
            + COLUMN_CORRECT_ANSWER+" TEXT,"
            + COLUMN_INCORRECT_ANSWERS+" TEXT"
            +")";

    public Question(){

    }
    public Question(Integer id,String category, String difficulty, String question, String correct_answer, ArrayList<String> incorrect_answers) {
        this.id=id;
        this.category = category;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }
    public int get_Answer_Count(){
        return 1+incorrect_answers.size();
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public ArrayList<String> getIncorrect_answers() {
        return incorrect_answers;
    }

    public void setIncorrect_answers(ArrayList<String> incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }

    @Override
    public String toString() {
        return question+correct_answer;
    }
}
