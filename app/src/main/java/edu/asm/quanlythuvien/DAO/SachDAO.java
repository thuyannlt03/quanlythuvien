package edu.asm.quanlythuvien.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.asm.quanlythuvien.Helper.SQLite;
import edu.asm.quanlythuvien.Model.Sach;

public class SachDAO {
    SQLite sqLite;
    public SachDAO(Context context){
        sqLite= new SQLite(context);
    }

    //lấy sách trong thư viện

    public ArrayList<Sach> getDSDauSach(){
        ArrayList<Sach> list = new ArrayList<>();
        SQLiteDatabase db = sqLite.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SACH", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do{
                list.add(new Sach(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3)));

            }while (cursor.moveToNext());
        }

        return list;
    }
}
