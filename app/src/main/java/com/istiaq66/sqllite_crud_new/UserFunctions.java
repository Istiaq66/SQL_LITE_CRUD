package com.istiaq66.sqllite_crud_new;


import android.content.Context;

import java.util.ArrayList;


public class UserFunctions {


    // constructor
    public UserFunctions() {

    }

    public void insertUserInfo(Context context, String name,
                                String mobile) {
        DatabaseHandler_in_ve db = new DatabaseHandler_in_ve(context);
        db.insertUserInfo(name,mobile);
    }


    public ArrayList<CustomList> getAllInfo(Context context){
        DatabaseHandler_in_ve db = new DatabaseHandler_in_ve(context);
        return db.getAllInfo(context);
    }

}
