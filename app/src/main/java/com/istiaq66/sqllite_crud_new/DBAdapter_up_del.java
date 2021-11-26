package com.istiaq66.sqllite_crud_new;



import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter_up_del {



    private static final String TAG = "DBAdapter_up_del";



    private static final int DATABASE_VERSION = 1;
    private static final String TAG_Mgs = "DatabaseHandoler";

    // Database Name
    private static final String DATABASE_NAME = "seqaepcon";
    // table name
    private static final String TABLE_USERINFO = "conuseoo";


    // user info table column name
    private static final String KEY_USERINFO_Id = "Id";
    private static final String KEY_USERINFO_NAMW = "name";
    //private static final String KEY_USERINFO_EMAIL = "email";
    //private static final String KEY_USERINFO_address = "address";
    //
    private static final String KEY_USERINFO_mobile = "mobile";
   // private static final String KEY_USERINFO_fax = "fax";
   // private static final String KEY_USERINFO_office = "office";
    //
    //private static final String KEY_USERINFO_DATE = "date";

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter_up_del(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                //db.execSQL(CREATE_Entertainment_INFO);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }


    //---opens the database---open dbhelper for writeable.........
    public DBAdapter_up_del open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }


    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }




    //for  update  data

    public boolean updateMisContact(long rowId, String name,String mobile) {

        ContentValues args = new ContentValues();
        args.put(KEY_USERINFO_NAMW, name);
        args.put(KEY_USERINFO_mobile, mobile);




        return db.update(TABLE_USERINFO, args, KEY_USERINFO_Id + "=" + rowId, null) > 0;
    }
//for  update  data

    //for delete data

    public boolean deleteMisContact(long rowId) {
        return db.delete(TABLE_USERINFO, KEY_USERINFO_Id + "=" + rowId, null) > 0;
    }


    //for delete data


}