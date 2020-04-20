이진 트리  검색 IP 주소
===================


이진 트리를 사용하여 IP 쿼리를 실현, 
십진 IPV4 주소를 이진으로 변환하여 이진 트리를 구성
IP를 기반으로 지역을 쿼리하기위한 인터페이스(findRegionByIp)는 아래와 같이 호출


IP String, IPv4, IPv6 형태 입력
```
String ip = "1.0.0.254";
String region = IpHelper.findRegionByIp(ip);
```
```
String ip = "1fff:0:0a88:85a3:0:0:ac1f:8001";
String region = IpHelper.findRegionByIp(ip, IPAddress.Type.IPv6);
```
```
String ip = "1.1.1.0";
String region = IpHelper.findRegionByIp(ip, IPAddress.Type.IPv4);
```

