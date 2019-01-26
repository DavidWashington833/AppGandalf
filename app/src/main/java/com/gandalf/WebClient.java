package com.gandalf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class WebClient {

    private String baseURL = "http://192.168.15.10:8090";

    public String get(String paramUrl) {
        try {
            URL url = new URL(baseURL + paramUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader streamReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new
                    StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            String result = responseStrBuilder.toString();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "deu ruim";
    }

    public String post(String paramUrl, String json) {
        try {
            URL url = new URL(baseURL + paramUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.connect();
            PrintStream output = new PrintStream(connection.getOutputStream());
            output.println(json);
            output.close();


            BufferedReader streamReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new
                    StringBuilder();
            String inputStr;

            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            String result = responseStrBuilder.toString();

            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "deu ruim";
    }
}
