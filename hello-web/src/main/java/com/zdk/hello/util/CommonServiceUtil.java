package com.zdk.hello.util;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;

import java.io.IOException;

public class CommonServiceUtil {

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    public static String queryWeatherByCityCode(Integer cityCode) {
        HttpUrl url = HttpUrl.parse("https://restapi.amap.com/v3/weather/weatherInfo").newBuilder()
                .addQueryParameter("key", "3a60b08ff24932f26ff2017d201f81ad")
                .addQueryParameter("city", cityCode.toString())
                .addQueryParameter("extensions", "base")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        StringBuilder res = new StringBuilder();
        try(Response response = HTTP_CLIENT.newCall(request).execute()) {
            ResponseBody body = response.body();
            if (response.isSuccessful() && body != null) {
                JSONObject jsonObject = JSON.parseObject(body.string());
                JSONArray lives = jsonObject.getJSONArray("lives");
                JSONObject city = lives.getJSONObject(0);
                res.append(city.getString("province")).append(city.getString("city")).append(":")
                        .append(city.get("weather")).append(",")
                        .append(city.get("temperature")).append("℃,")
                        .append(city.get("winddirection")).append("风").append(city.get("windpower")).append("级,")
                        .append("空气湿度").append(city.get("humidity")).append("%");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res.toString();
    }

}
