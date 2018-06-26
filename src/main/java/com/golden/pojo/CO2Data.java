package com.golden.pojo;

public class CO2Data {
    private Integer id;

    private String wifiid;

    private String shebeibiaozhi;

    private String shebeileixing;

    private String co2;

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

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2 == null ? null : co2.trim();
    }
}