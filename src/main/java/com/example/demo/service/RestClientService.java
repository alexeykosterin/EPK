package com.example.demo.service;

import com.example.demo.config.ErrorHandler;
import com.example.demo.config.RestClientProperties;
import com.example.demo.model.Todo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestClientService {

    private static RestTemplate restTemplate;
    private static RestClientProperties properties;

    public RestClientService(RestClientProperties properties) {
        this.restTemplate = new RestTemplate();
        this.restTemplate.setErrorHandler(
                new ErrorHandler());
        this.properties = properties;
    }

    public Iterable<Todo> findAll() throws URISyntaxException {
        RequestEntity<Iterable<Todo>> requestEntity = new RequestEntity<Iterable<Todo>>(
                HttpMethod.GET,
                new URI(properties.getUrl() + properties.getBasePath())
        );
                ResponseEntity<Iterable<Todo>> response = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Iterable<Todo>>() {
                });
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return null;
    }

    public List<Todo> findAllRatePlans() throws URISyntaxException {
        RequestEntity<List<Todo>> requestEntity = new RequestEntity
                <>(HttpMethod.GET, new URI(properties.getUrl() +
                properties.getBasePath()));
        ResponseEntity<List<Todo>> response =
                restTemplate.exchange(requestEntity, new ParameterizedTypeReference<>() {
                });
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return null;
    }

    public Todo findById(String id) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        return restTemplate.getForObject(properties.getUrl() + properties.
                getBasePath() + "/{id}", Todo.class, params);
    }

    public Todo upsert(Todo toDo) throws URISyntaxException {
        RequestEntity<?> requestEntity = new
                RequestEntity<>(toDo, HttpMethod.POST, new URI(properties.getUrl() +
                properties.getBasePath()));
        ResponseEntity<?> response = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<Todo>() {
                });
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return restTemplate.getForObject(response.getHeaders().
                    getLocation(), Todo.class);
        }
        return null;
    }

    public Todo setCompleted(String id) throws URISyntaxException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        restTemplate.postForObject(properties.getUrl() + properties.
                        getBasePath() + "/{id}?_method=patch", null, ResponseEntity.class,
                params);
        return findById(id);
    }

    public void delete(String id) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        restTemplate.delete(properties.getUrl() + properties.getBasePath()
                + "/{id}", params);
    }
}
