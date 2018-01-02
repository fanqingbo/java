package server;

import com.ppcredit.io.http.HttpRequest;
import common.GetProperty;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 加密
 * Created by fangcj7 on 2017/2/28.
 */
public class Encryption {
    public static void main(String[] args) {

        System.out.println(getEncryptionId("etl", "hbase", "adl", "dws_map_phone_idnumber", "phone", "18200102345"));
    }

    //加密
    public static String getEncryptionId(String clientId, String storage, String library, String table,
                                         String field, String id) {
        return remoteEncryption(clientId, storage, library, table, field, id);
    }

    private static String remoteEncryption(String clientId, String storage, String library, String table,
                                           String field, String id) {
        String result = "";
        String response = "";

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(id);

        JSONObject obj = new JSONObject();
        obj.put("clientId", clientId);
        obj.put("storage", storage);
        obj.put("library", library);
        obj.put("table", table);
        obj.put("field", field);
        obj.put("datas", arrayList);
        String url = GetProperty.getEncryptUrl();

        response = HttpRequest.postFromJson(url, obj);
        if (!response.equals("")) {
            System.out.println(response);

            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                if (jsonArray.getJSONObject(i).getString("code").equals("002")) {
                    result = jsonArray.getJSONObject(i).getString("body");
                }
            }
        }

        return result;
    }

    private static void localEncryption() {
    }
}
