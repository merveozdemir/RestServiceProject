package com.vaadin.service.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.vaadin.service.dto.ArizaDto;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestClientAriza {

    public ArizaDto arizaKaydet(ArizaDto arizaDto) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
        gsonBuilder.registerTypeAdapter(Date.class, new DateSerializer());
        Gson gson = gsonBuilder.create();

        String arizaDtoJson = gson.toJson(arizaDto);

        HttpPost post = new HttpPost("http://localhost:8080/rest/ariza/arizaKaydet");
        HttpEntity httpEntity = new StringEntity(arizaDtoJson, Charset.forName("utf-8"));
        post.setEntity(httpEntity);
        post.addHeader("content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            Type objectType = new TypeToken<ArizaDto>() {
            }.getType();

            ArizaDto savedArizaDto = gson.fromJson(dataAsJsonStr, objectType);
            return savedArizaDto;

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ArizaDto> adaGoreListele(String name) {
        Gson gson = new GsonBuilder().create();

        HttpPost post = new HttpPost("http://localhost:8080/rest/ariza/adaGoreListele");
        HttpEntity httpEntity = new StringEntity(name, Charset.forName("utf-8"));
        post.setEntity(httpEntity);
        post.addHeader("content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            Type listType = new TypeToken<ArrayList<ArizaDto>>() {
            }.getType();
            List<ArizaDto> arizaDtoList = gson.fromJson(dataAsJsonStr, listType);

            return arizaDtoList;

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ArizaDto> tcNoyaGoreListele(String musteriTcNo) {
        Gson gson = new GsonBuilder().create();

        HttpPost post = new HttpPost("http://localhost:8080/rest/ariza/tcNoyaGoreListele");
        HttpEntity httpEntity = new StringEntity(musteriTcNo, Charset.forName("utf-8"));
        post.setEntity(httpEntity);
        post.addHeader("content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            Type listType = new TypeToken<ArrayList<ArizaDto>>() {
            }.getType();

            List<ArizaDto> arizaDtoList = gson.fromJson(dataAsJsonStr, listType);
            return arizaDtoList;

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ArizaDto> tumArizaListele() {
        Gson gson = new GsonBuilder().create();

        HttpPost post = new HttpPost("http://localhost:8080/rest/ariza/tumArizaListele");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            Type listType = new TypeToken<ArrayList<ArizaDto>>() {
            }.getType();

            List<ArizaDto> arizaDtoList = gson.fromJson(dataAsJsonStr, listType);
            return arizaDtoList;

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
