package org.izardon.adapter.service;

import org.izardon.adapter.util.UrlHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockPriceApiService {
    private UrlHandler urlHandler;

    public StockPriceApiService(UrlHandler urlHandler) {
        this.urlHandler = urlHandler;
    }

    public Map<String, Float> getStockPrice(List<String> stockCodes) {
        Map<String, Float> stockPriceMap = new HashMap<>();

        try {
            // 創建 HttpURLConnection，設定並獲取連線
            String apiUrl = buildApiUrl(stockCodes);
            HttpURLConnection connection = createConnection(apiUrl);

            // Get the response code (HTTP status code)
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 讀取並處理回應內容
                String responseBody = readResponseContent(connection);
                JSONObject jsonResponse = new JSONObject(responseBody);
                setStockPrices(jsonResponse, stockPriceMap);
            } else {
                System.out.println("Request failed with response code: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return stockPriceMap;
    }

    private String buildApiUrl(List<String> stockCodes) {
        String apiUrl = "https://mis.twse.com.tw/stock/api/getStockInfo.jsp?ex_ch=";
        StringBuilder urlBuilder = new StringBuilder(apiUrl);

        for (String stockCode : stockCodes) {
            String tseCode = "tse_" + stockCode + ".tw";
            String otcCode = "otc_" + stockCode + ".tw";

            urlBuilder.append(tseCode).append("|").append(otcCode).append("|");
        }

        // Remove the trailing "|" character
        return urlBuilder.substring(0, urlBuilder.length() - 1);
    }

    public static String readResponseContent(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder responseContent = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            responseContent.append(line);
        }

        reader.close();
        return responseContent.toString();
    }

    private HttpURLConnection createConnection(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = urlHandler.openConnection(url);
        connection.setRequestMethod("GET");
        return connection;
    }

    private void setStockPrices(JSONObject jsonResponseObject, Map<String, Float> stockPriceMap) throws JSONException {
        JSONArray msgArray = jsonResponseObject.getJSONArray("msgArray");

        for (int i = 0; i < msgArray.length(); i++) {
            JSONObject stockData = msgArray.getJSONObject(i);
            String stockPrice = stockData.getString("pz");
            String stockCode = stockData.getString("c");

            System.out.println("Stock Price (pz): " + stockPrice);
            System.out.println("Stock Code (c): " + stockCode);
            stockPriceMap.put(stockCode, Float.valueOf(stockPrice));
        }
    }
}
