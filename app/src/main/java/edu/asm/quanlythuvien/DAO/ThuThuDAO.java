package edu.asm.quanlythuvien.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.asm.quanlythuvien.Helper.SQLite;

public class ThuThuDAO {
    SQLite sqLite;
    public ThuThuDAO(Context context){
        sqLite = new SQLite(context);
    }

    //Đăng nhập

    public boolean checkDN(String matt, String matkhau){
        SQLiteDatabase db = sqLite.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM THUTHU WHERE matt=? AND matkhau=?",new String[]{matt,matkhau});
        if (cursor.getCount()!=0)
            return true;
        return false;

    }
}
