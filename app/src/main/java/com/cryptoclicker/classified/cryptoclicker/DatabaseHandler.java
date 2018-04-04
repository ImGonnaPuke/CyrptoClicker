package com.cryptoclicker.classified.cryptoclicker;

import  android.content.Context;
import android.database.Cursor;
import  android.database.sqlite.SQLiteDatabase;
import  android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Npape on 3/13/2018.
 */
public class DatabaseHandler extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "cryptoClickerDatabase";
    private static final String TABLE_NAME = "data";
    private static final String CURRENCY_COLUMN = "currency";
    public DatabaseHandler(Context applicationcontext) {
        super(applicationcontext, DATABASE_NAME, null, 4);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table to insert data
        String query;
        String query1;
        query = "CREATE TABLE " +TABLE_NAME+ " ("+CURRENCY_COLUMN+ " INTEGER DEFAULT 0);";
        db.execSQL(query);
        query1 = "INSERT INTO data (currency)"+
                "VALUES (0);";
        db.execSQL(query1);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ;
        query = "DROP TABLE IF EXISTS "+TABLE_NAME+";";
        db.execSQL(query);
        onCreate(db);
    }

    public Cursor fetchCurrency(SQLiteDatabase db) {

        String[] projection = {
                CURRENCY_COLUMN
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = "ROWID" + " ASC" + " LIMIT" + " 1";

        return db.query(
                TABLE_NAME,
                projection,
                null, null, null, null,
                sortOrder
        );
    }
}