package com.example.medclock;

public class DataClass {
    private String dataMedicine;
    private String dataDate;
    private String dataTime;
    private String dataImage;
    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getDataMedicine() {
        return dataMedicine;
    }
    public String getDataDate() {
        return dataDate;
    }
    public String getDataTime() {
        return dataTime;
    }
    public String getDataImage() {
        return dataImage;
    }
    public DataClass(String dataMedicine, String dataDate, String dataTime, String dataImage) {
        this.dataMedicine = dataMedicine;
        this.dataDate = dataDate;
        this.dataTime = dataTime;
        this.dataImage = dataImage;
    }
    public DataClass(){
    }
}
