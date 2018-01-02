//package server;
//
//import dao.HbaseInstance;
//import dao.HbaseOperate;
//import entity.UserBasicInfo;
//import org.apache.hadoop.hbase.client.*;
//import org.apache.hadoop.hbase.util.Bytes;
//
///**
// * 用户基本信息
// * Created by fangcj7 on 2017/2/28.
// */
//public class UserBasicInfoSer {
//    public static UserBasicInfo getUserBasicInfo(String idnumber) {
//
//        UserBasicInfo userBasicInfo = null;
//        Result result = null;
//        if (!idnumber.isEmpty()) {
//            result = HbaseOperate.get("adl:dws_ppduser_basicinfo", idnumber);
//            if (result != null) {
//                userBasicInfo = new UserBasicInfo();
//                userBasicInfo.setIdnumber(Bytes.toString(result.getRow()));
//                userBasicInfo.setRealname(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("realname"))));
//                userBasicInfo.setGender(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("gender"))));
//                userBasicInfo.setIdbirth(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("idbirth"))));
//                userBasicInfo.setAge(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("age"))));
//                userBasicInfo.setEducationId(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("educationid"))));
//                userBasicInfo.setMarriagestatusId(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("marriagestatusid"))));
//                userBasicInfo.setBorrowerrole(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("occupationid"))));
//                userBasicInfo.setResidencetypeId(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("residencetypeid"))));
//                userBasicInfo.setHasbuycar(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("hasbuycar"))));
//                userBasicInfo.setNciiccityId(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("nciiccityid"))));
//                userBasicInfo.setResidenceAddress(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("residenceaddress"))));
//                userBasicInfo.setProvinceId(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("provinceid"))));
//                userBasicInfo.setCityId(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("cityid"))));
//                userBasicInfo.setDistrictId(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("districtid"))));
//                userBasicInfo.setAssessamountType(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("assessamounttype"))));
//                userBasicInfo.setAssets(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("assets"))));
//            }
//        }
//        System.out.println("get hbase resInfo");
//        return userBasicInfo;
//    }
//
//    public static void closeConn() {
//        try {
//            HbaseInstance.closeConn();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
