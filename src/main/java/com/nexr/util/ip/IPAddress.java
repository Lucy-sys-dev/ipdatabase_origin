package com.nexr.util.ip;
import javax.persistence.*;

/**
 * Create by lucy on 2020-04-20
 **/
public abstract class IPAddress {

    public static enum Type {
        IPv4, IPv6
    }

    protected String address;

    @Enumerated
    private Type type;


    public IPAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    final public boolean isIPv4() {
        return Type.IPv4 == type;
    }

    final public boolean isIPv6() {
        return Type.IPv6 == type;
    }

    public Type getType() {
        return type;
    }

    public static IPAddress createIPAddress(String addr, Type type) throws RuntimeException {
        if (type == Type.IPv4) {
            return new IPv4Address(addr);
        } else {
            return new IPv6Address(addr);
        }
    }

    public abstract String getIpString();

    public abstract String getIpv4String();

}
