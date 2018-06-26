package com.golden.pojo;

public class SoilData {
    private Integer id;

    private String wifiid;

    private String shebeibiaozhi;

    private String shebeileixing;

    private String temperature;

    private String humidity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWifiid() {
        return wifiid;
    }

    public void setWifiid(String wifiid) {
        this.wifiid = wifiid == null ? null : wifiid.trim();
    }

    public String getShebeibiaozhi() {
        return shebeibiaozhi;
    }

    public void setShebeibiaozhi(String shebeibiaozhi) {
        this.shebeibiaozhi = shebeibiaozhi == null ? null : shebeibiaozhi.trim();
    }

    public String getShebeileixing() {
        return shebeileixing;
    }

    public void setShebeileixing(String shebeileixing) {
        this.shebeileixing = shebeileixing == null ? null : shebeileixing.trim();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity == null ? null : humidity.trim();
    }
}