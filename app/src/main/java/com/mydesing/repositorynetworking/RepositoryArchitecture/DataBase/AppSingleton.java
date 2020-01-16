package com.mydesing.repositorynetworking.RepositoryArchitecture.DataBase;

import android.content.Context;

public class AppSingleton {
    private static AppSingleton INSTANCE;
    private DataBaseHelper dbHelper;
    public static AppSingleton getINSTANCE(Context context){
        if(INSTANCE==null){
            INSTANCE=new AppSingleton();
            INSTANCE.setDbHelper(new DataBaseHelper(context));
        }
        return INSTANCE;
    }


    public static void setINSTANCE(AppSingleton INSTANCE) {
        AppSingleton.INSTANCE = INSTANCE;
    }

    public DataBaseHelper getDbHelper() {
        return dbHelper;
    }

    public void setDbHelper(DataBaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }
}
