package server;

import com.ppcredit.io.http.HttpRequest;
import common.GetProperty;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 解密
 * Created by fangcj7 on 2017/2/28.
 */
public class Decryption {
//    public static void main(String[] args) {
//        System.out.println(getDecryptionId("etl", "hbase", "adl", "dws_ppduser_basicinfo", "idnumber",
//                "cmZetfQrD14LV07zPNVxWxtIyvgCcvDh36wfCz825NPGdnCEhBbNu96eYIyFM0DRcNBQx+5Ef80Aa6FXltqLY7Lmv24tPd61SKOe5nX5lCK9YTa8XLuPtzSFXoS1W7ILmfefkzLbgIxh2NeVuo59suEqJuIqx6/pKUTzhMR4268="));
//    }

    public static String getDecryptionId(String clientId, String storage, String library, String table,
                                         String field, String id) {
        return remoteDecryption(clientId, storage, library, table, field, id);
    }

    private static String remoteDecryption(String clientId, String storage, String library, String table,
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
        String url = GetProperty.getDecryptUrl();

        response = HttpRequest.postFromJson(url, obj);
        if (!response.equals("")) {
            System.out.println(response);

            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                if (jsonArray.getJSONObject(i).getString("code").equals("003")) {
                    result = jsonArray.getJSONObject(i).getString("body");
                }
            }
        }

        return result;
    }

    private static void localDecryption() {
    }
}
