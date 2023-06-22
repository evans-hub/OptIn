package com.apptivate.OptIn.Service.impl;

import com.apptivate.OptIn.Model.ClientModel;
import com.apptivate.OptIn.Utils.SingleItemResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Objects;

@Service
public class NetworkService {
    @Value("${gateway.base-service-url}")
    private String baseUrl;
    private final String URL_PART = "/api/v1";

    public static final String POST = "POST";
    public static final String GET = "GET";
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(NetworkService.class);

    public ResponseEntity<String> getData(HashMap<String, Object> data, HashMap<String, String> headersMap, String BASE) {
        return sendData(GET, data, headersMap, BASE);
        }


    public ResponseEntity<String> postData(HashMap<String, Object> data,  HashMap<String, String> headersMap, String BASE) {
        return sendData(POST, data, headersMap, BASE);
    }

    private ResponseEntity process(String urlPart, HttpMethod method, ClientModel data) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> result;
        try {
            HttpEntity<ClientModel> entity = new HttpEntity<>(data);
            result = restTemplate.exchange(baseUrl+urlPart, method, entity, String.class);
        } catch (final HttpClientErrorException e) {
            log.error(e.getResponseBodyAsString());
            log.error(e.getMessage());
            result = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
        log.info(result.getBody());
        return result;
    }
    private ResponseEntity sendData(String method, HashMap<String, Object> data, HashMap<String, String> headersMap, String BASE) {
        HttpHeaders headers = new HttpHeaders();
        if (headersMap != null) {
            for (String key : headersMap.keySet()) {
                headers.set(key, headersMap.get(key));
            }
        }


        RestTemplate restTemplate = new RestTemplate();
        HttpMethod httpMethod = null;
        if (method.equalsIgnoreCase(GET)) {
            httpMethod = HttpMethod.GET;
        } else if (method.equalsIgnoreCase(POST)) {
            httpMethod = HttpMethod.POST;
        }

        ResponseEntity<String> result;
        try {
            HttpEntity<HashMap<String, Object>> entity = new HttpEntity<>(data, headers);
            log.info("Method :" + method + " URL : " + BASE);
            log.error(Objects.requireNonNull(entity.getBody()).toString());
            result = restTemplate.exchange(BASE, httpMethod, entity, String.class);
        } catch (final HttpClientErrorException e) {
            log.error(e.getResponseBodyAsString());
            log.error(e.getMessage());
            result = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
        log.info(result.getBody());
        return result;
    }


    public ResponseEntity<String> sendRequest(String urlPart, HttpMethod method, ClientModel client) {
        return process(urlPart,method,client);
    }

}
