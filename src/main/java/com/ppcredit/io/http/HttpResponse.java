package com.ppcredit.io.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpResponse {
    /**
     * 连接url，得到json格式的结果
     *
     * @param url
     * @return
     */
    public static String conn(String url) {
        String result = "";
        try {
            String urlName = url;
            URL U = new URL(urlName);
            URLConnection connection = U.openConnection();
            connection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            in.close();
        } catch (Exception e) {
        }
        return result;
    }

}
