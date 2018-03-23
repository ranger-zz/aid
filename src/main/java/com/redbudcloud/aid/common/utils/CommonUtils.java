package com.redbudcloud.aid.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class CommonUtils {
    public static final String ERROR_RESPONSE = "ERROR_JSON_PARSER";
    public static String getJsonStringFromObject(Object m) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(m);
        return jsonStr;
    }
    public static Boolean isObjectEmpty(Object o) {
        if (o == null){
            return true;
        }
        if (o instanceof String){
            return isStringEmpty((String) o);
        } else if (o instanceof List) {
            return isListEmpty((List) o);
        } else if (o instanceof Map) {
            return isMapEmpty((Map) o);
        } else if (o instanceof Set) {
            return isSetEmpty((Set) o);
        } else {
            return false;
        }
    }

    public static Boolean isObjectNotEmpty(Object o){
        return !isObjectEmpty(o);
    }

    public static Boolean isStringEmpty(String str){
        if (str == null){
            return true;
        }
        str = str.trim();
        return str.length() == 0;
    }
    public static Boolean isStringNotEmpty(String str){
        return !isStringEmpty(str);
    }

    public static String getToen(String header){
        String tokenHead = Constants.TOKEN_HEAD;
        return header.substring(tokenHead.length());
    }
//    public static String successResponseStringWithToken(Object o,String token){
//        Map m = new HashMap();
//        m.put("resCode",0);
//        m.put("token", token);
//        m.put("result",o);
//        String resp = "";
//
//        try {
//            resp = JsonUtils.getJsonStringFromObject(m);
//        } catch (JsonProcessingException e) {
//            resp = JsonUtils.ERROR_RESPONSE;
//        }
//        return resp;
//    }

    public static String addTokenToResponseString(String token,String resp){
        String newresp = "";
        newresp = resp.substring(0,resp.length() - 1) + ",\"token\":" + token + "}";
        return newresp;
    }
    public static String successResponseString(Object o){
        Map m = new HashMap();
        m.put("resCode",0);
        m.put("result",o);
        String resp = "";

        try {
            resp = getJsonStringFromObject(m);
        } catch (JsonProcessingException e) {
            resp = ERROR_RESPONSE;
        }
        return resp;
    }

    public static String tokenExpiredResponseString(){
        Map m = new HashMap();
        m.put("resCode",2);
        m.put("result","Token过期，请重新登录。");
        String resp = "";

        try {
            resp = getJsonStringFromObject(m);
        } catch (JsonProcessingException e) {
            resp = ERROR_RESPONSE;
        }
        return resp;
    }

    public static String errorResponseString(String errorMsg){
        Map m = new HashMap();
        m.put("resCode",1);
        m.put("result",errorMsg);
        String resp = "";

        try {
            resp = getJsonStringFromObject(m);
        } catch (JsonProcessingException e) {
            resp = ERROR_RESPONSE;
        }
        return resp;
    }

    public static Boolean isListEmpty(List list){
        if (list == null || list.size() == 0){
            return true;
        }
        return false;
    }

    public static Boolean isListNotEmpty(List list){
        return !(isListEmpty(list));
    }

    public static Boolean isMapEmpty(Map map) {
        return (map == null || map.size() == 0) ? true : false;
    }

    public static Boolean isMapNotEmpty(Map map) {
        return !(isMapEmpty(map));
    }

    public static Boolean isSetEmpty(Set set){
        return (set == null || set.size() == 0) ? true : false;
    }

    public static Boolean isSetNotEmpty(Set set) {
        return !(isSetEmpty(set));
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static Long getLongValue(Object o){
        if (o == null) {
            return null;
        }
        if (o instanceof Long){
            return (Long) o;
        } else if (o instanceof Integer) {
            return new Long((Integer) o);
        } else if (o instanceof Short) {
            return new Long ((Short) o);
        } else {
            return null;
        }
    }

    public static Integer getIntegerValue(Object o){
        if (o == null) {
            return null;
        }
        if (o instanceof Integer) {
            return (Integer) o;
        } else if (o instanceof Long) {
            return ((Long) o).intValue();
        } else if (o instanceof Short) {
            return new Integer((Short) o);
        } else {
            return null;
        }
    }

    public static Double getDoubleValue(Object o){
        if (o == null){
            return null;
        }
        if (o instanceof Double) {
            return (Double) o;
        } else if (o instanceof Float) {
            return new Double((Float) o);
        } else {
            return null;
        }
    }

    public static Float getFloatValue(Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Float){
            return (Float) o;
        } else if (o instanceof Double) {
            return ((Double) o).floatValue();
        } else {
            return null;
        }
    }
}
