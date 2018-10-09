package esiea.com.polind;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDatabase {

        private static final int VERSION = 1;
        private static final String NAME_DATABASE = "polind.db";

        private static final String TABLE_USER = "user";
        private static final String COL_ID = "ID";
        private static final int NUM_COL_ID = 0;
        private static final String COL_EMAIL = "Email";
        private static final int NUM_COL_EMAIL = 1;
        private static final String COL_PASSWORD = "Password";
        private static final int NUM_COL_PASSWORD = 2;

        private SQLiteDatabase database;

        private UserSQLite userSQLite;

        public UserDatabase(Context context){
            userSQLite = new UserSQLite(context, NAME_DATABASE, null, VERSION);
        }

        public void open(){
            database = userSQLite.getWritableDatabase();
        }

        public void close(){
            database.close();
        }

        public SQLiteDatabase getDatabase(){
            return database;
        }

        public long insertUser(User user){
            ContentValues values = new ContentValues();
            values.put(COL_EMAIL, user.getEmail());
            values.put(COL_PASSWORD, user.getPassword());

            return database.insert(TABLE_USER, null, values);
        }

        public int updateUser(int id, User user){
            ContentValues values = new ContentValues();
            values.put(COL_EMAIL, user.getEmail());
            values.put(COL_PASSWORD, user.getPassword());

            return database.update(TABLE_USER, values,COL_ID + " = " + id, null);
        }

        public int removeUserWithID(int id){
            return database.delete(TABLE_USER, COL_ID + " = " + id,null);
        }

        public User getUserWithEmail(String email){
            Cursor c = database.query(TABLE_USER, new String[] {COL_ID, COL_EMAIL, COL_PASSWORD}, COL_EMAIL + " LIKE \"" + email +"\"", null, null, null, null);
            return cursorToUser(c);
        }


        private User cursorToUser(Cursor c) {
              if(c.getCount() == 0){
                  return null;
              }
              c.moveToFirst();
              User user = new User();
              user.setId(c.getInt(NUM_COL_ID));
              user.setEmail(c.getString(NUM_COL_EMAIL));
              user.setPassword(c.getString(NUM_COL_PASSWORD));

              c.close();

              return user;
        }

}
