package com.nexr.util.ip;

import com.google.api.client.util.Key;

/**
 * Create by lucy on 2020-04-20
 **/
public class IPv4Address extends IPAddress {
    @Key
    private Integer oct1;
    @Key
    private Integer oct2;
    @Key
    private Integer oct3;
    @Key
    private Integer oct4;

    public IPv4Address(String address) throws RuntimeException {
        super(address);

        int position1 = address.indexOf(".");
        int position2 = address.indexOf(".", position1 + 1);
        int position3 = address.indexOf(".", position2 + 1);

        oct1 = Integer.parseInt(address.substring(0, position1));
        oct2 = Integer.parseInt(address.substring(position1 + 1, position2));
        oct3 = Integer.parseInt(address.substring(position2 + 1, position3));
        oct4 = Integer.parseInt(address.substring(position3 + 1));

        IPValidator.getInstance().validateIPv4(address);
    }

    public String getIpString() {
        return String.format("%d.%d.%d.%d", this.getOct1(), this.getOct2(), this.getOct3(), this.getOct4());
    }

    public String getIpv4String() {
        return address;
    }

    public Integer getOct1() {
        return oct1;
    }

    public void setOct1(Integer oct1) {
        this.oct1 = oct1;
    }

    public Integer getOct2() {
        return oct2;
    }

    public void setOct2(Integer oct2) {
        this.oct2 = oct2;
    }

    public Integer getOct3() {
        return oct3;
    }

    public void setOct3(Integer oct3) {
        this.oct3 = oct3;
    }

    public Integer getOct4() {
        return oct4;
    }

    public void setOct4(Integer oct4) {
        this.oct4 = oct4;
    }

    public int getMaxPrefix() {
        return 32;
    }

    public Type getType() {
        return Type.IPv4;
    }


}
