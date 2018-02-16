package com.example.devarajakhil.attendance;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class MyDBSub extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ClassesDB.db";
    public static String TABLE_NAME = "StudentTable";
    public static final String COLUMN_ID = "StudentID";
    public static final String COLUMN_NAME = "StudentName";
    public MyDBSub(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS"+TABLE_NAME+" ( "+COLUMN_ID +" TEXT PRIMARY KEY AUTOINCREMENT , "+COLUMN_NAME+" TEXT )";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public List<Studata> getNotifications(String table) {
        SQLiteDatabase dbd = this.getReadableDatabase();
        List<Studata> x = new ArrayList<Studata>();

        Cursor res = dbd.rawQuery("select * from "+table, null);
        if (res != null) {
            if (res.getCount() > 0) {
                for (int i = 0; i < res.getCount(); i++) {
                    res.moveToNext();
                    Studata au1 = new Studata();
                    au1.id=res.getString(res.getColumnIndex("StudentID"));
                    au1.name = res.getString(res.getColumnIndex("StudentName"));
                    x.add(au1);
                }
            }
            dbd.close();
        }
        //res.close();
        return x;
    }
    public void addHandler(String table,String roll,String name) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,roll);
        Log.d("Here",table);
        values.put(COLUMN_NAME, name);

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(table, null, values);
        db.close();
    }
    public  void addcols(String table,String name,String is){
        ContentValues v = new ContentValues();
        SQLiteDatabase d = this.getWritableDatabase();
        //ALTER TABLE {tableName} ADD COLUMN COLNew {type};
        Date c = Calendar.getInstance().getTime();
        //System.out.println("Current time => " + c;

        SimpleDateFormat df = new SimpleDateFormat("ddMMMyyyy");
        String fo = "a"+df.format(c);
        try{
            d.execSQL("ALTER TABLE "+table+" ADD COLUMN "+fo+" TEXT");
        }
        catch (Exception e ){
            Log.v("OK","Alter Cannot BE Created");
            Log.v("OK",fo);
        }

        String sqll = "UPDATE "+table+" SET " + fo+ " = "+is+" WHERE StudentName = "+name;
    }

}