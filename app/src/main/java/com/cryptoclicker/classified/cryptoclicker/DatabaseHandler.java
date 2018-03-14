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
    private static final String DATABASE_NAME="CryptoClickerDatabase";
    private static final String CURRENCY_COLUMN="Currency";
    private static final String TABLE_NAME="Data";
    public DatabaseHandler(Context applicationcontext) {
        super(applicationcontext, DATABASE_NAME, null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table to insert data
        String query;
        query = "CREATE TABLE IF NOT EXISTS Data(Currency INTEGER);";
        db.execSQL(query);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ;
        query = "DROP TABLE IF EXISTS Data";
        db.execSQL(query);
        onCreate(db);
    }

    public double getCurrency() {

        Cursor currencyDB = getReadableDatabase().rawQuery("SELECT Currency FROM Data ORDER BY ROWID ASC LIMIT 1", null);
        double currency = currencyDB.getDouble(0);
        return currency;
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

    public double getValue() {

        Cursor cursor = getReadableDatabase().rawQuery("select Currency from Data", null);
        double total = 0;
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            total = cursor.getDouble(cursor.getColumnIndex("0"));
        }
        return total;
    }
}