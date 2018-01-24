package com.github.yhs0092.client.impl;

import java.util.HashMap;
import java.util.Map;

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
import com.github.yhs0092.hello.Hello;

import io.servicecomb.provider.pojo.RpcReference;
import io.servicecomb.provider.rest.common.RestSchema;
import io.servicecomb.provider.springmvc.reference.RestTemplateBuilder;

@RestSchema(schemaId = "helloClient")
@Path(value = "/hello")
@Produces(value = MediaType.TEXT_PLAIN)
public class HelloClientImpl implements HelloClient {
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloClientImpl.class);

  @RpcReference(microserviceName = "transport-header-server", schemaId = "paramTransportTest")
  private Hello hello;

  private RestTemplate restTemplate = RestTemplateBuilder.create();

  @Path(value = "/sayHello")
  @PUT
  @Override
  public String sayHello(@BeanParam HelloParam helloParam) {
    LOGGER.info("sayHello is called, helloParam = {}", helloParam);
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.add("headerParam", helloParam.getHeaderParam());
    HttpEntity<String> requestEntity = new HttpEntity<>(helloParam.getBodyParam(), requestHeaders);
    Map<String, String> uriParams = new HashMap<>(1);
    uriParams.put("queryParam", helloParam.getQueryParam());
    ResponseEntity<String> responseEntity = null;
    try {
      responseEntity = restTemplate
          .exchange("cse://transport-header-server/params/{pathParam}/test?queryParam={queryParam}",
              HttpMethod.POST, requestEntity, String.class, helloParam.getPathParam(), helloParam.getQueryParam());
      LOGGER.info("sayHello invocation finished, result = [{}]", responseEntity.getBody());
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      responseEntity = restTemplate
          .postForEntity("cse://transport-header-server/params/{pathParam}/test?queryParam={queryParam}",
              requestEntity, String.class, helloParam.getPathParam(), helloParam.getQueryParam());
      LOGGER.info("sayHello invocation finished, result = [{}]", responseEntity.getBody());
    } catch (Exception e) {
      e.printStackTrace();
    }

    String pojoResult = null;
    try {
      pojoResult = hello
          .sayHello(helloParam.getPathParam(), helloParam.getQueryParam(), helloParam.getHeaderParam(),
              helloParam.getBodyParam());
      LOGGER.info("sayHello pojo invoc finished, result = [{}]", pojoResult);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return (null == responseEntity ? "" : responseEntity.getBody()) + "  " + pojoResult;
  }
}
