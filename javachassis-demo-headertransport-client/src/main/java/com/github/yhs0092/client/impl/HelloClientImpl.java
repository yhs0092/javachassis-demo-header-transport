package com.github.yhs0092.client.impl;

import javax.ws.rs.BeanParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.github.yhs0092.client.HelloClient;
import com.github.yhs0092.client.HelloParam;

import io.servicecomb.provider.rest.common.RestSchema;
import io.servicecomb.provider.springmvc.reference.RestTemplateBuilder;

@RestSchema(schemaId = "helloClient")
@Path(value = "/hello")
@Produces(value = MediaType.TEXT_PLAIN)
public class HelloClientImpl implements HelloClient {
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloClientImpl.class);

  private static final String schema = "cse://";

  private static final String providerMicroServiceName = "transport-header-server";

  private static final String baseUrl = "/hello";

  private static final String sayHelloUrl = schema + providerMicroServiceName + baseUrl + "/sayHello";

  private RestTemplate restTemplate = RestTemplateBuilder.create();

  @Path(value = "/sayHello")
  @PUT
  @Override
  public String sayHello(@BeanParam HelloParam helloParam) {
    LOGGER.info("sayHello is called, helloParam = {}", helloParam);
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.add("index", helloParam.getIndex() == null ? null : helloParam.getIndex().toString());
    if (null != helloParam.getExpectStatus()) {
      requestHeaders.add("expectStatus", helloParam.getExpectStatus());
    }
    HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
    ResponseEntity<String> responseEntity = restTemplate.exchange(sayHelloUrl + "?name=" + helloParam.getName(),
        HttpMethod.GET, requestEntity, String.class);
    LOGGER.info("sayHello invocation finished, result = [{}]", responseEntity.getBody());
    return responseEntity.getBody();
  }
}
