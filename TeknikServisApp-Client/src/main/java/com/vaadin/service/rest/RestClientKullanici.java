package com.vaadin.service.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vaadin.service.dto.KullaniciDto;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class RestClientKullanici {

    public KullaniciDto kullaniciyiGetir(String kullaniciAdi, String sifre) {

        Gson gson = new GsonBuilder().create();
        String kullaniciIdSifre = "kullaniciAdi=" + kullaniciAdi + "&sifre=" + sifre;

        HttpPost post = new HttpPost("http://localhost:8080/rest/kullanici/kullaniciyiGetir");
        HttpEntity httpEntity = new StringEntity(kullaniciIdSifre, Charset.forName("utf-8"));
        post.setEntity(httpEntity);
        post.addHeader("content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            KullaniciDto currentKullaniciDto = gson.fromJson(dataAsJsonStr, KullaniciDto.class);
            return currentKullaniciDto;

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
