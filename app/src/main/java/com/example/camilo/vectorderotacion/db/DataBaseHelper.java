package com.example.camilo.vectorderotacion.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by camilo on 04/04/2017.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="movimientos.db";
    public static int VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE movimientos (_id INTEGER PRIMARY KEY AUTOINCREMENT"
                + ", mincial DOUBLE"
                + ", mfinal DOUBLE"+ ", mangulo DOUBLE"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE movimientos");
        onCreate(db);

    }
}
