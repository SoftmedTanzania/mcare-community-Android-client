package com.softmed.tanzania.referral;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Klabu.db";
    public static final String TABLE_NAME="Users";
    public static final String COL_0="dbId";
    public static final String COL_1="UserId";
    public static final String COL_2="RoleId";
    public static final String COL_3="FirstName";
    public static final String COL_4="MiddleName";
    public static final String COL_5="SurName";
    public static final String COL_6="JobRefNo";
    public static final String COL_7="mKey";


    public static final String TABLE_VILLAGE_JURISDICTION="chw_village_jurisdiction";
    public static final String COL_8="dbId";
    public static final String COL_9="VillageId";
    public static final String COL_10="VillageName";
    public static final String COL_11="VillageRefNo";


    public static final String TABLE_FACILITY_JURISDICTION="chw_facility_jurisdiction";
    public static final String COL_12="dbId";
    public static final String COL_13="FacilityId";
    public static final String COL_14="FacilityName";
    public static final String COL_15="PhysicalAddress";
    public static final String COL_16="FacilityRefNo";
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(dbId INTEGER PRIMARY KEY AUTOINCREMENT,UserId VARCHAR(200),RoleId VARCHAR(200),FirstName VARCHAR(200),MiddleName VARCHAR(200),SurName VARCHAR(200),JobRefNo VARCHAR(200),mKey VARCHAR(200))");
        db.execSQL("CREATE TABLE " + TABLE_VILLAGE_JURISDICTION + "(dbId INTEGER PRIMARY KEY AUTOINCREMENT,VillageId VARCHAR(200),VillageName VARCHAR(200),VillageRefNo VARCHAR(200))");
        db.execSQL("CREATE TABLE " + TABLE_FACILITY_JURISDICTION + "(dbId INTEGER PRIMARY KEY AUTOINCREMENT,FacilityId VARCHAR(200),FacilityName VARCHAR(200),PhysicalAddress VARCHAR(500),FacilityRefNo VARCHAR(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_VILLAGE_JURISDICTION);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_FACILITY_JURISDICTION);
        onCreate(db);

    }

    public boolean insertData(String UserId,String RoleId,String FirstName,String MiddleName,String SurName,String JobRefNo,String mKey)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,UserId);
        contentValues.put(COL_2, RoleId);
        contentValues.put(COL_3, FirstName);
        contentValues.put(COL_4, MiddleName);
        contentValues.put(COL_5, SurName);
        contentValues.put(COL_6, JobRefNo);
        contentValues.put(COL_7, mKey);

        long result=db.insert(TABLE_NAME,null,contentValues);

        if(result==-1)
            return false;
        else
            return true;

    }


    public boolean insertVillageJurisdiction(String VillageId,String VillageName,String VillageRefNo)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_9, VillageId);
        contentValues.put(COL_10, VillageName);
        contentValues.put(COL_11, VillageRefNo);


        long result=db.insert(TABLE_VILLAGE_JURISDICTION,null,contentValues);

        if(result==-1)
            return false;
        else
            return true;

    }



    public boolean insertFacilityJurisdiction(String FacilityId,String FacilityName,String PhysicalAddress,String FacilityRefNo)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_13, FacilityId);
        contentValues.put(COL_14, FacilityName);
        contentValues.put(COL_15, PhysicalAddress);
        contentValues.put(COL_16, FacilityRefNo);


        long result=db.insert(TABLE_FACILITY_JURISDICTION,null,contentValues);

        if(result==-1)
            return false;
        else
            return true;

    }





    public Cursor getAllCredentials()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM " +TABLE_NAME,null);
        return res;
    }

    public Integer deleteCredentials(String mKey)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME, " holder = ?",new String[] {mKey});
    }


    public boolean updateCredentials(String UserId,String RoleId,String FirstName,String MiddleName,String SurName,String JobRefNo,String mKey)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,UserId);
        contentValues.put(COL_2, RoleId);
        contentValues.put(COL_3, FirstName);
        contentValues.put(COL_4, MiddleName);
        contentValues.put(COL_5, SurName);
        contentValues.put(COL_6, JobRefNo);
        contentValues.put(COL_7, mKey);


        db.update(TABLE_NAME,contentValues, "mKey = ?",new String[] {mKey});

        return true;

    }


    public Integer deleteEntireTable(String TableName)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TableName,null,null);
    }



}
