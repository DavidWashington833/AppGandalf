package com.storegandalf.david.gandalf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Silva on 04/11/2017.
 */

public class WebClient {
    public String get(String paramUrl) {
        try {
            URL url = new URL(paramUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestProperty("Content-type", "application/json");
            //connection.setRequestProperty("Accept", "application/json");
            connection.setRequestMethod("GET");
            /*connection.setDoOutput(true);
            //connection.connect();
            PrintStream output = new PrintStream(connection.getOutputStream());
            output.println("{}");
            output.close();*/

//            int responseCode = connection.getResponseCode();

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
