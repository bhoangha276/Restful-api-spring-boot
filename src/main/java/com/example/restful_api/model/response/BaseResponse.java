package com.example.restful_api.model.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class BaseResponse {
    public static ResponseEntity<Object> ofSucceeded(Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", data);
        map.put("status", HttpStatus.OK);
        map.put("message", "Successfully!");

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}
