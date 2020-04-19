package com.nexr.util.ip;

import com.nexr.util.file.FileUtil;
import com.nexr.util.file.PoiUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by lucy on 2020-04-17
 **/
public class IpHelper {
    private static IpTree ipTree = IpTree.getInstance();

    private static final String ipFile = "ipDatabase.csv";

    private static final String regionFile = "ipRegion.xlsx";

    static{
        buildTrain();
    }

    private static void buildTrain() {
        List<IpRelation> ipRelationList;
        try {
            ipRelationList = IpHelper.getIpRelation();
            int count = 0;
            for (IpRelation ipRelation : ipRelationList) {
                ipTree.train(ipRelation.getIpStart(), ipRelation.getIpEnd(), ipRelation.getRoad());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* IP 주소를 전달하고 IP 주소가있는 도로명 반환
     */
    public static String findRegionByIp(String ip){
        return ipTree.findIp(ip);
    }

    public static List<IpRelation> getIpRelation() throws Exception {

        // <ipCode, province>
        Map<Integer, String> regionRelationMap = getRegionRelationMap();
        String file =  IpHelper.class.getClassLoader().getResource(ipFile).getFile();
        BufferedReader ipRelationReader = FileUtil.readFile(file);

        String line;
        List<IpRelation> list = new ArrayList<IpRelation>();
        while((line = ipRelationReader.readLine()) != null){
            String[] split = line.split(",");
            String ipStart = split[0];
            String ipEnd = split[1];
            Integer ipCode = Integer.valueOf(split[2]);

            String province = regionRelationMap.get(ipCode);
            IpRelation ipRelation = new IpRelation();
            ipRelation.setIpStart(ipStart);
            ipRelation.setIpEnd(ipEnd);
            ipRelation.setRoad(province);
            list.add(ipRelation);
        }
        return list;

    }

    public static Map<Integer, String> getRegionRelationMap() throws Exception {
        String file =  IpHelper.class.getClassLoader().getResource(regionFile).getFile();

        Workbook workbook = PoiUtil.getWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);
        Map<Integer, String> map = new HashMap<Integer, String>();
        int rowLen = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rowLen; i++) {
            Row row = sheet.getRow(i);
            String road = row.getCell(1).getStringCellValue();
            Double a = row.getCell(2).getNumericCellValue();
            Integer ipCode = a.intValue();
            map.put(ipCode, road);
        }

        return map;
    }
}
