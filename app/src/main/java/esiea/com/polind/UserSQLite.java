package esiea.com.polind;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class UserSQLite extends SQLiteOpenHelper {

    private static final String TABLE_USER = "table_users";
    private static final String COL_ID = "ID";
    private static final String COL_EMAIL = "Email";
    private static final String COL_PASSWORD = "Password";

    private static final String CREATE_BDD = "CREATE TABLE "+ TABLE_USER + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_EMAIL + " TEXT NOT NULL, " + COL_PASSWORD + " TEXT NOT NULL);";

    public UserSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_USER + ";");
        onCreate(db);
    }
}
