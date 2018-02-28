package com.thanh.utils;/*
  By Chi Can Em  28-02-2018
 */

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestHtml {
    public static String requestPostWithListPram(String url, HashMap<String, String> listParameter) {
        StringBuilder htmlChain = new StringBuilder();
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : listParameter.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));

            }

            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            HttpResponse response = client.execute(httpPost);
            BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                htmlChain.append(inputLine);
            }
            in.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return htmlChain.toString();
    }
}
