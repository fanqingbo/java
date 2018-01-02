//package server;
//
//import dao.HbaseInstance;
//import dao.HbaseOperate;
//import entity.PhoneMapIdnumber;
//import entity.QqMapIdnumber;
//import org.apache.hadoop.hbase.client.Result;
//import org.apache.hadoop.hbase.util.Bytes;
//
///**
// * Created by fangcj7 on 2017/2/28.
// */
//public class IdnumberSer {
//    public static QqMapIdnumber getIdnumberWithQQ(String qq) {
//        QqMapIdnumber qqMapIdnumber = null;
//        Result result = null;
//
//        if (!qq.isEmpty()) {
//            result = HbaseOperate.get("adl:dws_map_qq_idnumber", qq);
//            if (result != null) {
//                qqMapIdnumber = new QqMapIdnumber();
//                qqMapIdnumber.setQq(Bytes.toString(result.getRow()));
//                qqMapIdnumber.setIdnumber(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("idnumber"))));
//            }
//        }
//        return qqMapIdnumber;
//    }
//
//    public static PhoneMapIdnumber getIdnumberWithPhone(String phone) {
//        PhoneMapIdnumber phoneMapIdnumber = null;
//        Result result = null;
//
//        if (!phone.isEmpty()) {
//            result = HbaseOperate.get("adl:dws_map_phone_idnumber", phone);
//            if (result != null) {
//                phoneMapIdnumber = new PhoneMapIdnumber();
//                phoneMapIdnumber.setPhone(Bytes.toString(result.getRow()));
//                phoneMapIdnumber.setIdnumber(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("idnumber"))));
//            }
//        }
//        return phoneMapIdnumber;
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
