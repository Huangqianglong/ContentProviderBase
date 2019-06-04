package com.hql.databaseandprovider;

/**
 * @author ly-huangql
 * <br /> Create time : 2019/6/3
 * <br /> Description :
 */
public class WeatherBean {


    /**
     * result : 1
     * msg : SUCCESS
     * rows : {"tomoMinTem":"27","datWindDir":"北风","datMinTem":"27","temp":"25","datWindLevel":"2","tomoCondition":"阵雨","windLevel":"2","todayNum":2,"datCondition":"阵雨","windDir":"南风","tomoWindDir":"北风","tomoMaxTem":"30","aqiValue":"优","minTem":"25","condition":"阴","tomoWindLevel":"2","cityName":"深圳市","tomNum":3,"maxTem":"29","datMaxTem":"31","datNum":3,"cityID":707}
     */

    private String result;
    private String msg;
    private RowsBean rows;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * tomoMinTem : 27
         * datWindDir : 北风
         * datMinTem : 27
         * temp : 25
         * datWindLevel : 2
         * tomoCondition : 阵雨
         * windLevel : 2
         * todayNum : 2
         * datCondition : 阵雨
         * windDir : 南风
         * tomoWindDir : 北风
         * tomoMaxTem : 30
         * aqiValue : 优
         * minTem : 25
         * condition : 阴
         * tomoWindLevel : 2
         * cityName : 深圳市
         * tomNum : 3
         * maxTem : 29
         * datMaxTem : 31
         * datNum : 3
         * cityID : 707
         */

        private String tomoMinTem;
        private String datWindDir;
        private String datMinTem;
        private String temp;
        private String datWindLevel;
        private String tomoCondition;
        private String windLevel;
        private int todayNum;
        private String datCondition;
        private String windDir;
        private String tomoWindDir;
        private String tomoMaxTem;
        private String aqiValue;
        private String minTem;
        private String condition;
        private String tomoWindLevel;
        private String cityName;
        private int tomNum;
        private String maxTem;
        private String datMaxTem;
        private int datNum;
        private int cityID;

        public String getTomoMinTem() {
            return tomoMinTem;
        }

        public void setTomoMinTem(String tomoMinTem) {
            this.tomoMinTem = tomoMinTem;
        }

        public String getDatWindDir() {
            return datWindDir;
        }

        public void setDatWindDir(String datWindDir) {
            this.datWindDir = datWindDir;
        }

        public String getDatMinTem() {
            return datMinTem;
        }

        public void setDatMinTem(String datMinTem) {
            this.datMinTem = datMinTem;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getDatWindLevel() {
            return datWindLevel;
        }

        public void setDatWindLevel(String datWindLevel) {
            this.datWindLevel = datWindLevel;
        }

        public String getTomoCondition() {
            return tomoCondition;
        }

        public void setTomoCondition(String tomoCondition) {
            this.tomoCondition = tomoCondition;
        }

        public String getWindLevel() {
            return windLevel;
        }

        public void setWindLevel(String windLevel) {
            this.windLevel = windLevel;
        }

        public int getTodayNum() {
            return todayNum;
        }

        public void setTodayNum(int todayNum) {
            this.todayNum = todayNum;
        }

        public String getDatCondition() {
            return datCondition;
        }

        public void setDatCondition(String datCondition) {
            this.datCondition = datCondition;
        }

        public String getWindDir() {
            return windDir;
        }

        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        public String getTomoWindDir() {
            return tomoWindDir;
        }

        public void setTomoWindDir(String tomoWindDir) {
            this.tomoWindDir = tomoWindDir;
        }

        public String getTomoMaxTem() {
            return tomoMaxTem;
        }

        public void setTomoMaxTem(String tomoMaxTem) {
            this.tomoMaxTem = tomoMaxTem;
        }

        public String getAqiValue() {
            return aqiValue;
        }

        public void setAqiValue(String aqiValue) {
            this.aqiValue = aqiValue;
        }

        public String getMinTem() {
            return minTem;
        }

        public void setMinTem(String minTem) {
            this.minTem = minTem;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getTomoWindLevel() {
            return tomoWindLevel;
        }

        public void setTomoWindLevel(String tomoWindLevel) {
            this.tomoWindLevel = tomoWindLevel;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public int getTomNum() {
            return tomNum;
        }

        public void setTomNum(int tomNum) {
            this.tomNum = tomNum;
        }

        public String getMaxTem() {
            return maxTem;
        }

        public void setMaxTem(String maxTem) {
            this.maxTem = maxTem;
        }

        public String getDatMaxTem() {
            return datMaxTem;
        }

        public void setDatMaxTem(String datMaxTem) {
            this.datMaxTem = datMaxTem;
        }

        public int getDatNum() {
            return datNum;
        }

        public void setDatNum(int datNum) {
            this.datNum = datNum;
        }

        public int getCityID() {
            return cityID;
        }

        public void setCityID(int cityID) {
            this.cityID = cityID;
        }
    }
}
