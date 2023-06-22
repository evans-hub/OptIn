/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apptivate.OptIn.Utils;

/**
 * @author david
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Util<T> {

    private static final Logger LOG = Logger.getLogger(Util.class.getName());

    public static String getIP(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

    public static String toJson(Object entity) {
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static PrivateKey getPrivateKey(String filename) {
        PrivateKey privateKey = null;
        try {
            byte[] keyBytes = Files.readAllBytes(Paths.get(filename));
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            privateKey = kf.generatePrivate(spec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    public T fromJson(String json, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PublicKey getPublicKey(String filename) {
        PublicKey publicKey = null;
        try {
            byte[] keyBytes = Files.readAllBytes(Paths.get(filename));

            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            publicKey = kf.generatePublic(spec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publicKey;
    }


    public static ResponseEntity getResponse(Status status, Object entity) {
        ResponseEntity.BodyBuilder builder;
        if (status != null && status.getCode() == Response.ERROR_INVALID_ACCESS.status().getCode()) {
            builder = ResponseEntity.status(HttpStatus.FORBIDDEN);
        } else {
            builder = (status == null || status.getCode() == 0) ? ResponseEntity.ok() : ResponseEntity.badRequest();
        }
        return builder.body(status.getCode() == Response.SUCCESS.status().getCode() ? (entity != null ? entity : status) : status);
    }

    public ItemResponse<T> getResponse(ResponseEntity<String> responseEntity, Class<T> clazz) {
        Status status;
        if (responseEntity.getBody() != null && !responseEntity.getBody().isEmpty()) {
            if (responseEntity.getStatusCodeValue() == 200) {
                T item = fromJson(responseEntity.getBody(), clazz);
                status = Response.SUCCESS.status();
                return new ItemResponse<>(status, item);
            } else {
                StatusExtended statusExtended = new Util<StatusExtended>().fromJson(responseEntity.getBody(), StatusExtended.class);
                if (statusExtended.getStatus() != null) {
                    status = new Status(statusExtended.getStatus(), statusExtended.getMessage());
                } else {
                    status = new Status(statusExtended.getCode(), statusExtended.getMessage());
                    if (statusExtended.getErrors() != null && !statusExtended.getErrors().isEmpty()) {
                        StringBuilder message = new StringBuilder();
                        message.append(status.getMessage()).append("\n");
                        int i = 1;
                        for (Status error : statusExtended.getErrors()) {
                            message.append(i).append(") ").append(error.getMessage()).append("\n");
                            i++;
                        }
                        status.setMessage(message.toString());
                    }
                }
                return new ItemResponse<>(status, null);
            }
        } else {
            status = Response.INVALID_RESPONSE.status();
            return new ItemResponse<>(status, null);
        }
    }

    public static Double convertBigDecimalToDouble(BigDecimal value) {
        return value.doubleValue();
    }

    public static Integer convertDoubleToInt(Double value) {
        return value.intValue();
    }

    public static Integer converLongToInt(Long value) {
        return value.intValue();
    }

    public static String converIntToString(Integer value) {
        return Integer.toString(value);
    }

    public static Integer converStringToInt(String value) {
        return Integer.parseInt(value);
    }

    public static String getDisplayDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("EAT"));
        return formatter.format(date);
    }

    public static String getDisplayDateTime(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh.mm.ss aa");
        dateFormat.setTimeZone(TimeZone.getTimeZone("EAT"));
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public static String getTimestamp() {
        final String TIMESTAMP_PATTERN = "yyyyMMddHHmmss";
        SimpleDateFormat formatter = new SimpleDateFormat(TIMESTAMP_PATTERN);
        String date = formatter.format(new Date());
        return date;
    }

    public static String getToken(HttpServletRequest httpServletRequest) {
        String TOKEN_PREFIX = "Bearer ";
        String AUTH_STRING = "Authorization";
        String token = httpServletRequest.getHeader(AUTH_STRING) ;
        return token != null ? token.replace(TOKEN_PREFIX, "") : null;
    }

    public static String getQueryString(int page, int size, String searchParam, String fromDate, String toDate, Integer id) {
        return getQueryString(null, null, page, size, searchParam, null, null, null, null, null, null, null, null, null, fromDate, toDate, id);
    }

    public static String getQueryString(String direction, String orderBy, int page, int size, String searchParam, String status) {
        return getQueryString(direction, orderBy, page, size, searchParam, null, null, null, null, null, status, null, null, null, null, null, null);
    }

    public static String getQueryString(String direction, String orderBy, int page, int size, String searchParam, String status,String fromDate,String toDate) {
        return getQueryString(direction, orderBy, page, size, searchParam, null, null, null, null, null, status, null, null, null, fromDate, toDate, null);
    }


    public static String getQueryString(String direction, String orderBy, Integer page, Integer size, String searchParam, Integer clientId, Integer branchId, String status, String wallet, String fromDate, String toDate) {
        return getQueryString(direction, orderBy, page, size, searchParam, null, clientId, branchId, null, null, status, null, null, wallet, fromDate, toDate, null);
    }

    public static String getQueryString(String direction, String orderBy, int page, int size, String searchParam, Integer client, String clientType, Integer branchId, String branchType) {
        return getQueryString(direction, orderBy, page, size, searchParam, null, client, branchId, null, null, null, clientType, branchType, null, null, null, null);
    }

    public static String getQueryString(String direction, String orderBy, int page, int size, String searchParam, Integer merchantId, Integer clientId, Integer branchId, Integer outletId, Integer employeeId, String fromDate, String toDate) {
        return getQueryString(direction, orderBy, page, size, searchParam, merchantId, clientId, branchId, outletId, null, null, null, null, null, fromDate, toDate, null);
    }

    public static String getQueryString(String direction, String orderBy, Integer page, Integer size, String searchParam, Integer merchantId, Integer clientId, Integer branchId, Integer outletId, Integer employeeId, String status, String clientType, String branchType, String wallet, String fromDate, String toDate, Integer id) {
        String queryStr = "?" + (direction != null ? "direction=" + direction : "") + (orderBy != null ? "&oderBy=" + orderBy : "") + (page != null ? "&page=" + page : 0) + (size != null ? "&size=" + size : 0) + (searchParam != null ? "&search="
                + searchParam : "") + (merchantId != null ? "&merchantId=" + merchantId : "") + (outletId != null ? "&outletId=" + outletId : "") + (employeeId != null ? "&employeeId=" + employeeId : "")
                + (clientId != null ? ("&clientId=" + clientId + "&client=" + clientId) : "") + (branchId != null ? "&branchId=" + branchId : "") + (status != null ? "&status=" + status : "")
                + (clientType != null ? "&clientType=" + clientType : "")
                + (branchType != null ? "&branchType=" + branchType : "") + (branchId != null ? "&clientBranch=" + branchId : "") + (branchId != null ? "&clientBranchId=" + branchId : "") + (wallet != null ? "&wallet=" + wallet : "")
                + (fromDate != null ? "&fromDate=" + fromDate : "") + (toDate != null ? "&toDate=" + toDate : "") + (id != null ? "&id=" + id : "");
        LOG.log(Level.INFO, "Query Str :{0}", queryStr);
        return queryStr;
    }

}
