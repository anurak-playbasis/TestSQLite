package com.example.testsqlite.model;

import android.provider.BaseColumns;

public class FriendBase {
    public static final int version = 1;
    public static final String database_name = "friend_table.db";
    public static final String table_name = "friend";

    public class colunm {
        public static final String ID = BaseColumns._ID;
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String TEL = "tel";
        public static final String EMAIL = "email";
        public static final String DESCRIPTION = "description";
    }
}
