package com.nexr.util;

import com.nexr.util.ip.IPAddress;
import com.nexr.util.ip.IpHelper;
import org.junit.Test;

/**
 * Create by lucy on 2020-04-17
 **/
public class TestClient {
    @Test
    public void example() throws Exception {
        String ip = "1.0.0.254";
        String region = IpHelper.findRegionByIp(ip);
        System.out.println(region);
    }

    @Test
    public void example_ipv6() throws Exception {
        String ip = "1fff:0:0a88:85a3:0:0:ac1f:8001";
        String region = IpHelper.findRegionByIp(ip, IPAddress.Type.IPv6);

        System.out.println(region);
    }

    @Test
    public void example_ipv4() throws Exception {
        String ip = "1.1.1.0";
        String region = IpHelper.findRegionByIp(ip, IPAddress.Type.IPv4);

        System.out.println(region);
    }
}
