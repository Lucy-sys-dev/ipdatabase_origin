package com.nexr.util.ip;

/**
 * Create by lucy on 2020-04-17
 **/
public class IpRelation {
    private String ipStart;

    private String ipEnd;

    private int ipCode;

    private String region;

    private String road;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getIpCode() {
        return ipCode;
    }

    public void setIpCode(int ipCode) {
        this.ipCode = ipCode;
    }

    public String getIpEnd() {
        return ipEnd;
    }

    public void setIpEnd(String ipEnd) {
        this.ipEnd = ipEnd;
    }

    public String getIpStart() {
        return ipStart;
    }

    public void setIpStart(String ipStart) {
        this.ipStart = ipStart;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }
}


