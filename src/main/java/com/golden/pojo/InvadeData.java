package com.golden.pojo;

import java.util.Date;

public class InvadeData {
    private Integer id;

    private String wifiid;

    private String shebeibiaozhi;

    private String shebeileixing;

    private String invade;

    private Date date;

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

    public String getInvade() {
        return invade;
    }

    public void setInvade(String invade) {
        this.invade = invade == null ? null : invade.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}