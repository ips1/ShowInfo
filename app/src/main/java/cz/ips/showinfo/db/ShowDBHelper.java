package cz.ips.showinfo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by petrkubat on 03/02/15.
 */

public class ShowDBHelper extends SQLiteOpenHelper {


    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public ShowDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ShowDBStatements.SQL_CREATE_SHOWS);
        //db.execSQL(ShowDBStatements.SQL_CREATE_SEASONS);
        db.execSQL(ShowDBStatements.SQL_CREATE_EPISODES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(ShowDBStatements.SQL_DELETE_EPISODES);
        //db.execSQL(ShowDBStatements.SQL_CREATE_SEASONS);
        db.execSQL(ShowDBStatements.SQL_DELETE_SHOWS);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
