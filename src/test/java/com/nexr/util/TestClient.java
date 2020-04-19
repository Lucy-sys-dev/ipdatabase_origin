package com.nexr.util;

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
}
