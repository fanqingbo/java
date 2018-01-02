package myTest;


import com.csvreader.CsvReader;
import com.ppcredit.io.http.HttpRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by fanqingbo on 2017/3/10.
 */
public class MyCsv1 {

    public static void main(String[] args) throws Exception {
        String filename = "query_result.csv";
        String inputFile = "c://" + filename;
        String outputFile = "c://de" + filename;
        String url = "http://192.168.213.89:9000/encrypt/do_decrypt";
        JSONObject obj = new JSONObject();
        String response = "";
        CsvReader reader = new CsvReader(new FileReader(inputFile), ',');
        reader.readHeaders();
        String[] headers = reader.getHeaders();
        String result = null;
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        ArrayList<String[]> csvList = new ArrayList<String[]>();
        ArrayList<String> arrayList = new ArrayList<String>();
        while (reader.readRecord()) { //逐行读入除表头的数据
            csvList.add(reader.getValues());
        }
        for (int m = 0; m < headers.length; m++) {
            if (m < headers.length - 1) {
                bw.write(headers[m]);
                bw.write(",");
                bw.write("RESULT");
                bw.write(",");
            } else if (m == headers.length - 1) {
                bw.write(headers[m]);
                bw.write(",");
                bw.write("RESULT" + "\n");
            }
        }
        //逐行读取
        for (int row = 0; row < csvList.size(); row++) {
            for (int i = 0; i < headers.length; i++) {
                String[] strr = headers[i].split("\\.");
                String cell = csvList.get(row)[i];//取得第row行第i列的数据
                arrayList.add(cell);
                obj.put("clientId", "etl");
                obj.put("storage", strr[0]);
                obj.put("library", strr[1]);
                obj.put("table", strr[2]);
                obj.put("field", strr[3]);
                obj.put("datas", arrayList);
                response = HttpRequest.postFromJson(url, obj);
                arrayList.clear();
                if (!response.equals("")) {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int k = 0; k < jsonArray.length(); k++) {
                        if (jsonArray.getJSONObject(k).getString("code").equals("003")) {
                            result = jsonArray.getJSONObject(k).getString("body");
                            if (i < headers.length - 1) {
                                bw.write(cell);
                                bw.write(",");
                                bw.write(result);
                                bw.write(",");
                            } else if (i == headers.length - 1) {
                                bw.write(cell);
                                bw.write(",");
                                bw.write(result + "\n");
                            }
                        }
                    }
                }
            }
        }
        br.close();
        bw.close();
    }
}
