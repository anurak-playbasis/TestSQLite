package com.example.testsqlite.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.testsqlite.model.FriendBase;
import com.example.testsqlite.model.FriendData;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase sqlDatabase;

    public DBHelper(Context context) {
        super(context, FriendBase.database_name, null,FriendBase.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createFriendTable = String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",FriendBase.table_name,FriendBase.colunm.ID,FriendBase.colunm.FIRST_NAME,
                FriendBase.colunm.LAST_NAME,FriendBase.colunm.TEL,FriendBase.colunm.EMAIL,FriendBase.colunm.DESCRIPTION);
        db.execSQL(createFriendTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //When database is change version...
        String DROP_FRIEND_TABLE = String.format("DROP TABLE IF EXISTS %s",FriendBase.table_name);
        db.execSQL(DROP_FRIEND_TABLE);
        onCreate(db);
    }
    public List<String> getFriendList(){
        List<String> friend = new ArrayList<String>();
        sqlDatabase = this.getWritableDatabase();

        Cursor cursor = sqlDatabase.query(FriendBase.table_name, null, null, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        while(!cursor.isAfterLast()) {

            friend.add(cursor.getLong(0) + " " +
                    cursor.getString(1) + " " +
                    cursor.getString(2) + " " +
                    cursor.getString(3));

            cursor.moveToNext();
        }
        sqlDatabase.close();
        return friend;
    }
    public void addFriend(FriendData friendData) {

        Log.i(TAG, "XXXXXXXXXXXXXXXXXXXXXXXXXX:  " + "addFriend");
        sqlDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FriendBase.colunm.ID, friendData.getId());
        values.put(FriendBase.colunm.FIRST_NAME, friendData.getFirstName());
        values.put(FriendBase.colunm.LAST_NAME, friendData.getLastName());
        values.put(FriendBase.colunm.TEL, friendData.getPhone());
        values.put(FriendBase.colunm.EMAIL,friendData.getEmail());
        values.put(FriendBase.colunm.DESCRIPTION,friendData.getDescription());

        sqlDatabase.insert(FriendBase.table_name, null, values);

        sqlDatabase.close();
    }
}
