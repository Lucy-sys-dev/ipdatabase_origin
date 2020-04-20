이진 트리  검색 IP 주소
===================


이진 트리를 사용하여 IP 쿼리를 실현, 
십진 IPV4 주소를 이진으로 변환하여 이진 트리를 구성
이진 트리 검색을 사용 

IPv4, IPv6 형태 입력
```
String ip = "1fff:0:0a88:85a3:0:0:ac1f:8001";
String region = IpHelper.findRegionByIp(ip, IPAddress.Type.IPv6);
```
```
String ip = "1.1.1.0";
        String region = IpHelper.findRegionByIp(ip, IPAddress.Type.IPv4);
```

