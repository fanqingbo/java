package common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 从外部配置信息里面拿到配置信息
 * Created by fangcj7 on 2017/3/1.
 */
public class GetProperty {
    private static String quorum = "192.168.213.31";
    private static String clientPort = "2181";
    private static String encryptUrl = "http://192.168.213.89:9000/encrypt/do_encrypt";
    private static String decryptUrl = "http://192.168.213.89:9000/encrypt/do_decrypt";
    private static String clientId = "etl";
    private static String batchStorage = "hive";
    private static String batchLibrary = "obdl";
    private static String batchTable = "userdetails";
    private static String batchField = "phone";
    private static String fileDir = "c:/";

    static {
        Properties prop = new Properties();
        try {
            String path = System.getProperty("user.dir");
            InputStream in = new BufferedInputStream(new FileInputStream(path + "/conf/label.properties"));
            prop.load(in);

            fileDir = path;
            quorum = prop.getProperty("quorum");
            clientPort = prop.getProperty("clientPort");
            encryptUrl = prop.getProperty("encryptUrl");
            decryptUrl = prop.getProperty("decryptUrl");
            clientId = prop.getProperty("clientId");
            batchStorage = prop.getProperty("batchStorage");
            batchLibrary = prop.getProperty("batchLibrary");
            batchTable = prop.getProperty("batchTable");
            batchField = prop.getProperty("batchField");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getQuorum() {
        return quorum;
    }

    public static String getClientPort() {
        return clientPort;
    }

    public static String getEncryptUrl() {
        return encryptUrl;
    }

    public static String getDecryptUrl() {
        return decryptUrl;
    }

    public static String getClientId() {
        return clientId;
    }

    public static String getFileDir() {
        return fileDir;
    }

    public static String getBatchStorage() {
        return batchStorage;
    }

    public static String getBatchLibrary() {
        return batchLibrary;
    }

    public static String getBatchTable() {
        return batchTable;
    }

    public static String getBatchField() {
        return batchField;
    }


}
