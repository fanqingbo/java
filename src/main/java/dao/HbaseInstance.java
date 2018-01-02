//package dao;
//
//import common.GetProperty;
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.apache.hadoop.hbase.client.Connection;
//import org.apache.hadoop.hbase.client.ConnectionFactory;
//
///**
// * Created by fangcj7 on 2017/2/28.
// */
//public class HbaseInstance {
////    private static String quorum = "192.168.213.31";
////    private static String clientPort = "2181";
//    private static Configuration conf = null;
//    private static Connection conn = null;
//
////    static {
////        Properties prop = new Properties();
////        try {
////            String path=System.getProperty("user.dir");
////            InputStream in = new BufferedInputStream(new FileInputStream(path + "/conf/label.properties"));
////            prop.load(in);
////
////            quorum = prop.getProperty("quorum");
////            clientPort = prop.getProperty("clientPort");
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//    public static synchronized Configuration getConfiguration()
//    {
//        if(conf == null)
//        {
//            conf =  HBaseConfiguration.create();
//            conf.set("hbase.zookeeper.quorum", GetProperty.getQuorum());
//            conf.set("hbase.zookeeper.property.clientPort", GetProperty.getClientPort());
//        }
//        return conf;
//    }
//
//    public static synchronized Connection getHConnection() throws Exception
//    {
//        if(conn == null)
//        {
//            conn=ConnectionFactory.createConnection(getConfiguration());
//        }
//        return conn;
//    }
//
//    public static synchronized void closeConn() throws Exception {
//        if (conn != null) {
//            conn.close();
//            conn = null;
//        }
//    }
//}
