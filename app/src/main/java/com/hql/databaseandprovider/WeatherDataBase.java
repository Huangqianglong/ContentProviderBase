package com.hql.databaseandprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author ly-huangql
 * <br /> Create time : 2019/6/3
 * <br /> Description :
 */
public class WeatherDataBase extends SQLiteOpenHelper {
    private final String TAG = "Mr.H";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Weather.db";
    public static final String TEXT_TYPE = " TEXT ";
    public static final String INT_TYPE = " Integer ";
    public static final String COMMA_SEP = ",";

    private static final String CITYSQL_CREATE_ENTRIES =
            "CREATE TABLE " + Constants.TABLE_CITY + " (" +
                    Constants.LABEL_CITY_ID + "  INTEGER NOT NULL ,FOREIGN KEY " + COMMA_SEP +
                    Constants.LABEL_CITY_NAME + TEXT_TYPE + " )";

    private static final String WEATHERSQL_CREATE_ENTRIES =
            "CREATE TABLE " + Constants.TABLE_WEATHER + " (" +
                    Constants.LABEL_WEATHER_ID + " INTEGER PRIMARY KEY " + COMMA_SEP +

                    Constants.LABEL_TOMO_ICON + INT_TYPE + COMMA_SEP +//图标
                    Constants.LABEL_TOMO_LEVEL + TEXT_TYPE + COMMA_SEP +//空气质量
                    Constants.LABEL_TOMO_MAX_TEM + TEXT_TYPE + COMMA_SEP +//最高温度
                    Constants.LABEL_TOMO_MIN_TEM + TEXT_TYPE + COMMA_SEP +//最低温度
                    Constants.LABEL_TOMO_WIND_DIR + TEXT_TYPE + COMMA_SEP +//风向

                    Constants.LABEL_DAT_ICON + INT_TYPE + COMMA_SEP +//图标
                    Constants.LABEL_DAT_LEVEL + TEXT_TYPE + COMMA_SEP +//空气质量
                    Constants.LABEL_DAT_MAX_TEM + TEXT_TYPE + COMMA_SEP +//最高温度
                    Constants.LABEL_DAT_MIN_TEM + TEXT_TYPE + COMMA_SEP +//最低温度
                    Constants.LABEL_DAT_WIND_DIR + TEXT_TYPE + COMMA_SEP +//风向


                    Constants.LABEL_ICON + INT_TYPE + COMMA_SEP +//图标
                    Constants.LABEL_LEVEL + TEXT_TYPE + COMMA_SEP +//空气质量
                    Constants.LABEL_MAX_TEM + TEXT_TYPE + COMMA_SEP +//最高温度
                    Constants.LABEL_MIN_TEM + TEXT_TYPE + COMMA_SEP +//最低温度
                    Constants.LABEL_WIND_DIR + TEXT_TYPE + COMMA_SEP +//风向

                    Constants.LABEL_AIR_QUA + TEXT_TYPE + COMMA_SEP +//空气质量
                    Constants.LABEL_CONDITION + TEXT_TYPE + COMMA_SEP +//当天实时天气
                    Constants.LABEL_TEMP + TEXT_TYPE + COMMA_SEP +//当天实时温度
                    Constants.LABEL_CITY_ID + INT_TYPE + COMMA_SEP +
                    Constants.LABEL_CITY_NAME + TEXT_TYPE +
                    //Constants.TABLE_CITY + " INTEGER NOT NULL ,FOREIGN KEY (" + Constants.TABLE_CITY + ") REFERENCES " + Constants.TABLE_CITY + " (" + Constants.LABEL_CITY_ID + "));";
                    ")";

    private static final String CITYSQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Constants.TABLE_CITY;
    private static final String WEATHERSQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Constants.TABLE_WEATHER;

    public WeatherDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "创建城市数据库：" + CITYSQL_CREATE_ENTRIES);
        Log.d(TAG, "创建天气数据库：" + WEATHERSQL_CREATE_ENTRIES);
        // db.execSQL(CITYSQL_CREATE_ENTRIES);
        db.execSQL(WEATHERSQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "更新数据库");
        //  db.execSQL(CITYSQL_DELETE_ENTRIES);
        db.execSQL(WEATHERSQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
