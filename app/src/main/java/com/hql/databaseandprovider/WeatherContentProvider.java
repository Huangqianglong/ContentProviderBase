package com.hql.databaseandprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author ly-huangql
 * <br /> Create time : 2019/6/3
 * <br /> Description :
 */
public class WeatherContentProvider extends ContentProvider {
    private final String TAG = "Mr.H";
    private static final String AUTHORITIES = "com.hql.provider";
    private static final String PATH = "com.hql.test.service.weatherdb";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITIES);
    //public static final Uri CONTENT_URI_TEST = Uri.parse("content://" + "com.hql.test.service.weather.info.provider");
    private static final UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int URI_CODE = 1;

    static {
        mUriMatcher.addURI(AUTHORITIES, PATH, URI_CODE);
    }

    Context mContext;
    WeatherDataBase mWeatherDataBase;

    @Override
    public boolean onCreate() {
        mContext = getContext();
        mWeatherDataBase = new WeatherDataBase(mContext);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        if (mUriMatcher.match(uri) == URI_CODE) {
            SQLiteDatabase db = mWeatherDataBase.getWritableDatabase();
            // SQLiteDatabase db = new WeatherDataBase(getContext()).getWritableDatabase();
            Cursor cursor = db.query(Constants.TABLE_WEATHER, projection, selection, selectionArgs, null, null, null);
            //Cursor cursor =   db.query(Constants.TABLE_WEATHER, new String[]{Constants.LABEL_CITY_ID}, Constants.LABEL_CITY_ID + " = ?", new String[]{("707")}, null, null, null);

            Log.d(TAG, "数据库 查询 cursor>>>>>>>" + cursor.getCount());
            return cursor;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        if (mUriMatcher.match(uri) == URI_CODE) {
            SQLiteDatabase db = mWeatherDataBase.getWritableDatabase();
            long row = db.insert(Constants.TABLE_WEATHER, null, values);
            if (row != -1) {
                getContext().getContentResolver().notifyChange(CONTENT_URI, null);
            }
            Log.d(TAG, "数据库 插入 cursor>>>>>>>");
            return CONTENT_URI;
        }
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        if (mUriMatcher.match(uri) == URI_CODE) {
            SQLiteDatabase db = mWeatherDataBase.getWritableDatabase();
            //SQLiteDatabase db = new WeatherDataBase(getContext()).getWritableDatabase();
            //db.update(Constants.TABLE_WEATHER, values, Constants.LABEL_CITY_ID + " = ?", args);
            int row = db.update(Constants.TABLE_WEATHER, values, selection + " = ?", selectionArgs);
            if (row != -1) {
                getContext().getContentResolver().notifyChange(CONTENT_URI, null);
            }
            Log.d(TAG, "数据库 更新 cursor>>>>>>>");
            return row;
        }
        return 0;
    }
}
