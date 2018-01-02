//package dao;
//
//import org.apache.hadoop.hbase.TableName;
//import org.apache.hadoop.hbase.client.*;
//import org.apache.hadoop.hbase.util.Bytes;
//
///**
// * Created by fangcj7 on 2017/2/28.
// */
//public class HbaseOperate {
//    public static Result get(String tablename, String row) {
//        Table table = null;
//        Result result = null;
//        try {
//            Connection coon = HbaseInstance.getHConnection();
//            System.out.println("get hbase coon");
//            table = coon.getTable(TableName.valueOf(tablename));
//            Get get = new Get(Bytes.toBytes(row));
//            result = table.get(get);
//            System.out.println("get hbase result");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (table != null) {
//                try {
//                    table.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return result;
//    }
//}
