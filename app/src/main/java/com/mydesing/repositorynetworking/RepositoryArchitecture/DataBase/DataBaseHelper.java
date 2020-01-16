package com.mydesing.repositorynetworking.RepositoryArchitecture.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mydesing.repositorynetworking.model.Question;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="notes_db";
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Question.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Question.TABLE_NAME);
            onCreate(sqLiteDatabase);
    }
    public long insertQuestion(Question question){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Question.COLUMN_CATEGORY,question.getCategory());
        values.put(Question.COLUMN_DIFFICULTY,question.getCategory());
        values.put(Question.COLUMN_QUESTION,question.getQuestion());
        values.put(Question.COLUMN_CORRECT_ANSWER,question.getCorrect_answer());
        String incorrect_answer="";
        for(String wrong_Answer:question.getIncorrect_answers()){
            incorrect_answer+=wrong_Answer+"|";
        }
        incorrect_answer=incorrect_answer.substring(0,incorrect_answer.length()-1);
        values.put(Question.COLUMN_INCORRECT_ANSWERS,incorrect_answer);

        long id=db.insert(Question.TABLE_NAME,null,values);
        db.close();
        return id;
    }
//    public void remove(long id_note){
//        SQLiteDatabase db=getWritableDatabase();
//        String Note_Where_clause="WHERE "+Note.COLUMN_ID+"=?";
//        String []selectionArguments=new String[]{String.valueOf(id_note)};
//        db.delete(Note.TABLE_NAME,Note_Where_clause,selectionArguments);
//
//
//        db.close();
//    }
//    public Note getNoteById(long id_note){
//        String Get_Note_Query="SELECT * FROM "+Note.TABLE_NAME+" WHERE "+Note.COLUMN_ID+"=?";
//        SQLiteDatabase db=getReadableDatabase();
//        String []selectionArguments=new String[]{String.valueOf(id_note)};
//        Cursor cursor=db.rawQuery(Get_Note_Query,selectionArguments);
//        Note note=null;
//        if(cursor.moveToFirst()){
//            Integer id=cursor.getInt(cursor.getColumnIndex(Note.COLUMN_ID));
//            String date=cursor.getString(cursor.getColumnIndex(Note.COLUMN_DATE));
//            String descpirtion=cursor.getString(cursor.getColumnIndex(Note.COLUMN_NOTE));
//            note=new Note(descpirtion,date,id);
//        }
//        cursor.close();
//        db.close();
//
//        return note;
//    }
//    public List<Note> getAllNotes(){
//        List<Note>notes=new ArrayList<Note>();
//        final String GET_ALL_NOTE_QUERY="SELECT * FROM "+Note.TABLE_NAME;
//        SQLiteDatabase db=getReadableDatabase();
//        Cursor cursor=db.rawQuery(GET_ALL_NOTE_QUERY,null);
//        if(cursor.moveToFirst()){
//            do{
//
//                Integer id=cursor.getInt(cursor.getColumnIndex(Note.COLUMN_ID));
//                String date=cursor.getString(cursor.getColumnIndex(Note.COLUMN_DATE));
//                String descpirtion=cursor.getString(cursor.getColumnIndex(Note.COLUMN_NOTE));
//                Note note=new Note(descpirtion,date,id);
//                notes.add(note);
//            }
//            while(cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//
//        return notes;
//    }
    public List<Question>getAllQuestions(){
        List<Question>questions=new ArrayList<>();
        final String GET_ALL_NOTE_QUERY="SELECT * FROM "+Question.TABLE_NAME;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery(GET_ALL_NOTE_QUERY,null);

        if(cursor.moveToFirst()){
            do{
                Integer id=cursor.getInt(cursor.getColumnIndex(Question.COLUMN_ID));
                String category=cursor.getString(cursor.getColumnIndex(Question.COLUMN_CATEGORY));
                String difficulty=cursor.getString(cursor.getColumnIndex(Question.COLUMN_DIFFICULTY));
                String question=cursor.getString(cursor.getColumnIndex(Question.COLUMN_QUESTION));
                String correct_answer=cursor.getString(cursor.getColumnIndex(Question.COLUMN_CORRECT_ANSWER));
                String answers_wrong=cursor.getString(cursor.getColumnIndex(Question.COLUMN_INCORRECT_ANSWERS));
                ArrayList<String> incorrect_answers = new ArrayList<>(Arrays.asList(answers_wrong.split("|")));

                Question newQuestion=new Question(id,category,difficulty,question,correct_answer,incorrect_answers);

                questions.add(newQuestion);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return questions;
    }

}
