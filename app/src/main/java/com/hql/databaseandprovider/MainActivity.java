package com.hql.databaseandprovider;

import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private final String TAG = "Mr.H";
    TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        mTv = findViewById(R.id.tv_test);
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
        getContentResolver().registerContentObserver(WeatherContentProvider.CONTENT_URI, true, mContentObserver);
    }

    public boolean insertData() {
        Gson gson = new Gson();
        WeatherBean weatherBean = gson.fromJson("{ \"result\": \"1\", \"msg\": \"SUCCESS\", \"rows\": {     \"tomoMinTem\": \"27\",     \"datWindDir\": \"北风\",     \"datMinTem\": \"27\",     \"temp\": \"25\",     \"datWindLevel\": \"2\",     \"tomoCondition\": \"阵雨\",     \"windLevel\": \"2\",     \"todayNum\": 2,     \"datCondition\": \"阵雨\",     \"windDir\": \"南风\",     \"tomoWindDir\": \"北风\",     \"tomoMaxTem\": \"30\",     \"aqiValue\": \"优\",     \"minTem\": \"25\",     \"condition\": \"阴\",     \"tomoWindLevel\": \"2\",     \"cityName\": \"深圳市\",     \"tomNum\": 3,     \"maxTem\": \"29\",     \"datMaxTem\": \"31\",     \"datNum\": 3, \"cityID\":707 }}", WeatherBean.class);
        WeatherBean.RowsBean rowsBean = weatherBean.getRows();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.LABEL_TOMO_WIND_DIR, rowsBean.getTomoWindDir());
        contentValues.put(Constants.LABEL_TOMO_LEVEL, rowsBean.getTomoWindLevel());
        contentValues.put(Constants.LABEL_TOMO_MAX_TEM, rowsBean.getTomoMaxTem());
        contentValues.put(Constants.LABEL_TOMO_MIN_TEM, rowsBean.getTomoMinTem());

        contentValues.put(Constants.LABEL_DAT_WIND_DIR, rowsBean.getDatWindDir());
        contentValues.put(Constants.LABEL_DAT_LEVEL, rowsBean.getDatWindLevel());
        contentValues.put(Constants.LABEL_DAT_MAX_TEM, rowsBean.getDatMaxTem());
        contentValues.put(Constants.LABEL_DAT_MIN_TEM, rowsBean.getDatMinTem());

        contentValues.put(Constants.LABEL_WIND_DIR, rowsBean.getWindDir());
        contentValues.put(Constants.LABEL_LEVEL, rowsBean.getWindLevel());
        contentValues.put(Constants.LABEL_MAX_TEM, rowsBean.getMaxTem());
        contentValues.put(Constants.LABEL_MIN_TEM, rowsBean.getMinTem());

        contentValues.put(Constants.LABEL_ICON, rowsBean.getTodayNum());
        contentValues.put(Constants.LABEL_TOMO_ICON, rowsBean.getTomNum());
        contentValues.put(Constants.LABEL_DAT_ICON, rowsBean.getDatNum());
        contentValues.put(Constants.LABEL_DAT_ICON, rowsBean.getDatNum());

        //ContentValues CityContentValues = new ContentValues();
        contentValues.put(Constants.LABEL_CITY_NAME, rowsBean.getCityName() + "llll");
        Log.d(TAG, "city id>>>>:" + rowsBean.getCityID());
        contentValues.put(Constants.LABEL_CITY_ID, rowsBean.getCityID());
        contentValues.put(Constants.LABEL_AIR_QUA, rowsBean.getAqiValue());
        contentValues.put(Constants.LABEL_CONDITION, rowsBean.getAqiValue());
        contentValues.put(Constants.LABEL_TEMP, rowsBean.getAqiValue());

        //db.insert(Constants.TABLE_CITY, null, CityContentValues);
        //db.insert(Constants.TABLE_WEATHER, null, contentValues);
        String[] args = {String.valueOf(rowsBean.getCityID())};
        Cursor cursor = null;
        long index = -1l;
        try {
            // SQLiteDatabase db;
            // cursor = db.query(Constants.TABLE_WEATHER, new String[]{Constants.LABEL_CITY_ID}, Constants.LABEL_CITY_ID + " = ?", new String[]{(rowsBean.getCityID() + "")}, null, null, null);
            cursor = getContentResolver().query(WeatherContentProvider.CONTENT_URI, new String[]{Constants.LABEL_CITY_ID, Constants.LABEL_CITY_NAME}, Constants.LABEL_CITY_ID + " = ?", new String[]{(rowsBean.getCityID() + "")}, null, null);
            if (cursor.moveToFirst()) {
                //index = db.update(Constants.TABLE_WEATHER, contentValues, Constants.LABEL_CITY_ID + " = ?", args);
                getContentResolver().update(WeatherContentProvider.CONTENT_URI, contentValues, Constants.LABEL_CITY_ID + " = ?", args);
                Log.d(TAG, "测试 更新 >>>>>>>>>>>>>" + index + ">>>cursor:" + cursor.getString(1));
            } else {
                Log.d(TAG, "测试 插入 >>>>>>>>>>>>>" + index);
                // index = db.insert(Constants.TABLE_WEATHER, null, contentValues);
                getContentResolver().insert(WeatherContentProvider.CONTENT_URI, contentValues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != cursor) {
                cursor.close();
            }
        }
        Log.d(TAG, "update>>>>>>>>>>>>>" + index);
        // db.setTransactionSuccessful();
        // updateData();
        return true;
    }

    Runnable mInsertRun = new Runnable() {
        @Override
        public void run() {
            insertData();
        }
    };

    private void updateData() {
        mHandler.postDelayed(mInsertRun, 3000);
    }

    @Override
    protected void onDestroy() {
        mHandler.removeCallbacks(mInsertRun);
        getContentResolver().unregisterContentObserver(mContentObserver);
        super.onDestroy();
    }

    private ContentObserver mContentObserver = new ContentObserver(mHandler) {
        @Override
        public void onChange(boolean selfChange) {
            Log.e(TAG, "onChange: =======+>>>>>>>>>>>>selfChange is " + selfChange);
            super.onChange(selfChange);
        }
    };

}
