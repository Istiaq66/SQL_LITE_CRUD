package com.istiaq66.sqllite_crud_new;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class DatabaseHandler_in_ve extends SQLiteOpenHelper {

    private static final String TAG_Mgs = "DatabaseHandoler";



    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "seqaepcon";
    // table name
    private static final String TABLE_USERINFO = "conuseoo";

    // user info table column name
    private static final String KEY_USERINFO_Id = "Id";
    private static final String KEY_USERINFO_NAMW = "name";
    private static final String KEY_USERINFO_mobile = "mobile";

    public DatabaseHandler_in_ve(Context context) {


        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub



        try {
            String CREATE_USERINFO = "CREATE TABLE " + TABLE_USERINFO + "("
                    + KEY_USERINFO_Id + "  INTEGER PRIMARY KEY, "
                    + KEY_USERINFO_NAMW + " TEXT, "
                    + KEY_USERINFO_mobile+ " TEXT" +")";

            db.execSQL(CREATE_USERINFO);
        } catch (Exception e) {

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub


        Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);

    }



    // insert data
    public void insertUserInfo(String name,  String mobile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_USERINFO_NAMW, name);
         //
        values.put(KEY_USERINFO_mobile,mobile);

        // Inserting Row
        db.insert(TABLE_USERINFO, null, values);
        db.close(); // Closing database connection
    }


    //----------------------view data


    public ArrayList<CustomList> getAllInfo(Context context) {

        ArrayList<CustomList> userInfoList = new ArrayList<CustomList>();


        try {

            String selectQuery = "SELECT  * FROM  "+ TABLE_USERINFO+"" ;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            cursor.moveToFirst();  //Move the cursor to the first row.



            //Returns whether the cursor is pointing to the position after the last row.
            while (!cursor.isAfterLast()) {
                CustomList customList = new CustomList();

                String Id = cursor.getString(0).toString();
                customList.setStrId(Id);
                String name = cursor.getString(1).toString();
                customList.setStrName(name);
                String mobile = cursor.getString(2).toString();
                customList.setStrMobile(mobile);

                userInfoList.add(customList);
                cursor.moveToNext();  //Move the cursor to the next row.
            }
            cursor.close();
            db.close();

        }

        catch (Exception ex) {
            Log.e("getCampaignId Excep. :", ex.toString());
        }

        return userInfoList;
    }






/*	public void deleteAll()
	{
	    SQLiteDatabase db = this.getWritableDatabase();
	      db.delete(TABLE_USERINFO,null,null);
	    //db.execSQL("delete * from"+ TABLE_NAME);
	    //db.execSQL("TRUNCATE table" + TABLE_USERINFO);
	    db.close();
	}
	*/


}

