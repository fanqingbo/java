package com.ppcredit.io.http;


import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by fanqingbo on 2017/2/28.
 * 发送http请求
 */
public class HttpRequest {
    public static String postFromJson(String p_url, JSONObject obj) {
        String result = "";
        try {
            // 创建url资源
            URL url = new URL(p_url);
            // 建立http连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置允许输出
            conn.setDoOutput(true);

            conn.setDoInput(true);
            // 设置不用缓存
            conn.setUseCaches(false);
            // 设置传递方式
            conn.setRequestMethod("POST");
            // 设置维持长连接
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 设置文件字符集:
            conn.setRequestProperty("Charset", "UTF-8");
            //转换为字节数组
            byte[] data = (obj.toString()).getBytes();
            // 设置文件长度
            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
            // 设置文件类型:
            conn.setRequestProperty("Content-Type", "application/json");
            // 开始连接请求
            conn.connect();
            OutputStream out = conn.getOutputStream();
            // 写入请求的字符串
            out.write((obj.toString()).getBytes());
            out.flush();
            out.close();

            // 请求返回的状态
            if (conn.getResponseCode() == 200) {
                // 请求返回的数据
                InputStream in = conn.getInputStream();
                try {

                    byte[] data1 = new byte[in.available()];
                    in.read(data1);

                    // 转成字符串
                    result = new String(data1);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else {
                System.out.println("en-decryption server error" + conn.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
