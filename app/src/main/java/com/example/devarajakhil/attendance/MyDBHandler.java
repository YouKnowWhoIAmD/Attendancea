package com.example.devarajakhil.attendance;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import static java.sql.Types.INTEGER;
public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ClassesDB.db";
    public static final String TABLE_NAME = "ClassesMain";
    public static final String COLUMN_ID = "ClassID";
    public static final String COLUMN_NAME = "ClassName";
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS"+TABLE_NAME+" ( "+COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAME+" TEXT "+")";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public List<MyData> getNotifications() {
        SQLiteDatabase dbd = this.getReadableDatabase();
        List<MyData> x = new ArrayList<MyData>();

        Cursor res = dbd.rawQuery("select * from " + TABLE_NAME, null);
        if (res != null) {
            if (res.getCount() > 0) {
                for (int i = 0; i < res.getCount(); i++) {
                    res.moveToNext();
                    MyData au1 = new MyData();
                    au1.name = res.getString(res.getColumnIndex("ClassName"));
                    x.add(au1);
                }
            }
            dbd.close();
        }
        return x;
    }
    public void addHandler(String entered) {
        ContentValues values = new ContentValues();
        SQLiteDatabase dd = this.getWritableDatabase();
        dd.execSQL("CREATE TABLE IF NOT EXISTS "+entered+" ( StudentID INTEGER PRIMARY KEY AUTOINCREMENT ,StudentName TEXT )");
        values.put(COLUMN_NAME, entered);
        SQLiteDatabase dbd = this.getWritableDatabase();
        dbd.insert(TABLE_NAME, null, values);
        dbd.close();
    }


}