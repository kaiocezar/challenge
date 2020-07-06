package com.labs.challenge.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ApiLuizaProductUtils {

    RestTemplate restTemplate;

    ApiLuizaProductUtils(){
        restTemplate = new RestTemplate();
    }

    public List<ProductWrapper> getProductsWrapper(String page){
    Wrapper responseEntity = this.restTemplate
            .getForObject("http://challenge-api.luizalabs.com/api/product/?page="+page, Wrapper.class);
        return responseEntity.getProducts();
    }
}
