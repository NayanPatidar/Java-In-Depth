package com.Server;

import com.Validator.CardValidator;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FormSubmissionHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())){
            String formData = extractFormData(exchange);
            String CardNumber = extractCardNumber(formData);
            String validOrNot = checkValidation(CardNumber);

            System.out.println(CardNumber);

            String response = "Card Number: " + CardNumber + validOrNot;

            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }else {
            String response = "Method not allowed.";
            exchange.sendResponseHeaders(405, response.getBytes().length);
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }

    private String checkValidation(String cardNumberInStr) {
        CardValidator obj = new CardValidator();
        Long cardNumber = Long.valueOf(cardNumberInStr);
        boolean result = obj.check(cardNumber);
        String status = "";
        if (result == true){
            status = " is valid !!";
        } else if (result == false) {
            status = " is invalid !!";
        }
        return status;
    }

    private String extractFormData(HttpExchange exchange) throws IOException {
        byte[] buffer = new byte[100];
        int length = exchange.getRequestBody().read(buffer);
        return new String(buffer, 0 ,length, StandardCharsets.UTF_8);
    }

    private String extractCardNumber(String formData) {
        Map<String, String> datamap = parseFormData(formData);
        return datamap.getOrDefault("cardNumber", "");
    }

    private Map<String, String> parseFormData(String formData) {
        Map<String, String> dataMap = new HashMap<>();
        String[] keyValuePairs = new String[1];
        keyValuePairs[0] = formData;
        for (String pair : keyValuePairs) {
            String[] parts = pair.split("=");
            if (parts.length == 2){
                String key = parts[0];
                String value = parts[1];
                dataMap.put(key, value);
            }
        }
        return dataMap;
    }
}