package edu.asm.quanlythuvien.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {

    public SQLite (Context context){
        super(context,"DANGKYMONHOC",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String dbThuThu = "CREATE TABLE THUTHU (matt text primary key, hoten text, matkhau text)";
        db.execSQL(dbThuThu);
        String dbThanhVien = "CREATE TABLE THANHVIEN (matv integer primary key autoincrement, hoten text, namsinh text)";
        db.execSQL(dbThanhVien);
        String dbLoai =  "CREATE TABLE LOAISACH (maloai integer primary key autoincrement, tenloai text)";
        db.execSQL(dbLoai);
        String dbSach = "CREATE TABLE SACH (masach integer primary key autoincrement, tensach text, giathue integer, maloai integer references LOAISACH(maloai))";
        db.execSQL(dbSach);
        String dbPhieuMuon = "CREATE TABLE PHIEUMUON (mapm integer primary key autoincrement, matv integer references THANHVIEN(matv),matt text references THUTHU(matt), masach integer references SACH(masach), tienthue integer, ngay text, trasach integer)";
        db.execSQL(dbPhieuMuon);


        //data

        db.execSQL("INSERT INTO LOAISACH VALUES (1,'Thiếu nhi'),(2,'Tình cảm'),(3,'Giáo khoa')");
        db.execSQL("INSERT INTO SACH VALUES (1,'Hãy đợi đấy',2500,2),(2,'Thằng cuội',3000,1),(3,'Ngữ Văn 12',4000,3)");
        db.execSQL("INSERT INTO THUTHU VALUES ('thuthu01','Nguyễn Văn A','abc123'),('thuthu02','Nguyễn Thị B','123abc')");
        db.execSQL("INSERT INTO THANHVIEN VALUES (1,'Nguyễn Văn C',2000),(2,'Nguyễn Văn D',20001),(3,'Nguyễn Văn E',2002)");
        db.execSQL("INSERT INTO PHIEUMUON VALUES (1,2,'thuthu01',2,3000,11/09/2022,14/09/2022),(2,1,'thuthu01',3,4000,09/09/2022,01/10/2022),(3,3,'thuthu02',2,2500,20/09/2022,25/09/2022)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i !=i1){
            db.execSQL("DROP TABLE IF EXISTS THUTHU");
            db.execSQL("DROP TABLE IF EXISTS THANHVIEN");
            db.execSQL("DROP TABLE IF EXISTS LOAISACH");
            db.execSQL("DROP TABLE IF EXISTS SACH");
            db.execSQL("DROP TABLE IF EXISTS PHIEUMUON");

            onCreate(db);
        }
    }
}
