package com.nexr.util.ip;

import org.jetbrains.annotations.NotNull;

import static com.nexr.util.ip.IPAddress.Type;
import com.google.api.client.util.Key;

/**
 * Create by lucy on 2020-04-19
 **/
class IPv6Address extends IPAddress {
    @Key
    private String block1;
    @Key
    private String block2;
    @Key
    private String block3;
    @Key
    private String block4;
    @Key
    private String block5;
    @Key
    private String block6;
    @Key
    private String block7;
    @Key
    private String block8;

    public IPv6Address(String address) throws RuntimeException {
        super(address);
        int position1 = address.indexOf(":");
        int position2 = address.indexOf(":", position1 + 1);
        int position3 = address.indexOf(":", position2 + 1);
        int position4 = address.indexOf(":", position3 + 1);
        int position5 = address.indexOf(":", position4 + 1);
        int position6 = address.indexOf(":", position5 + 1);
        int position7 = address.indexOf(":", position6 + 1);


        block1 = address.substring(0, position1);
        block2 = address.substring(position1 + 1, position2);
        block3 = address.substring(position2 + 1, position3);
        block4 = address.substring(position3 + 1, position4);
        block5 = address.substring(position4 + 1, position5);
        block6 = address.substring(position5 + 1, position6);
        block7 = address.substring(position6 + 1, position7);
        block8 = address.substring(position7 + 1);


        IPValidator.getInstance().validateIPv6(address);
    }

    public int getMaxPrefix() {
        return 128;
    }

    public Type getType() {
        return Type.IPv6;
    }

    public String getIpString() {
        return String.format("%s:%s:%s:%s:%s:%s:%s:%s", getBlock1(), getBlock2(), getBlock3(), getBlock4(), getBlock5(), getBlock6(), getBlock7(), getBlock8());
    }

    public String getIpv4String() {
        String[] ipSplit = address.split(":");
        String str1 = ipSplit[ipSplit.length - 2].substring(0, 2);
        String str2 = ipSplit[ipSplit.length - 2].substring(2);
        String str3 = ipSplit[ipSplit.length - 1].substring(0,2);
        String str4 = ipSplit[ipSplit.length - 1].substring(2);
        return Integer.parseInt(str1, 16) + "." +
                Integer.parseInt(str2, 16) + "." +
                Integer.parseInt(str3, 16) + "." +
                Integer.parseInt(str4, 16);
    }

    public String getBlock1() {
        return block1;
    }

    public void setBlock1(String block1) {
        this.block1 = block1;
    }

    public String getBlock2() {
        return block2;
    }

    public void setBlock2(String block2) {
        this.block2 = block2;
    }

    public String getBlock3() {
        return block3;
    }

    public void setBlock3(String block3) {
        this.block3 = block3;
    }

    public String getBlock4() {
        return block4;
    }

    public void setBlock4(String block4) {
        this.block4 = block4;
    }

    public String getBlock5() {
        return block5;
    }

    public void setBlock5(String block5) {
        this.block5 = block5;
    }

    public String getBlock6() {
        return block6;
    }

    public void setBlock6(String block6) {
        this.block6 = block6;
    }

    public String getBlock7() {
        return block7;
    }

    public void setBlock7(String block7) {
        this.block7 = block7;
    }

    public String getBlock8() {
        return block8;
    }

    public void setBlock8(String block8) {
        this.block8 = block8;
    }

}
