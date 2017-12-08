package com.github.yhs0092.hello.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.github.yhs0092.hello.Hello;

import io.servicecomb.provider.rest.common.RestSchema;

@RestSchema(schemaId = "hello")
@Path(value = "/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloImpl implements Hello {
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloImpl.class);

  @Value("${server.name}")
  private String serverName;

  @Path("/sayHello")
  @GET
  @Override
  public String sayHello(
      @QueryParam(value = "name") String name,
      @HeaderParam(value = "index") String index,
      @HeaderParam("expectStatus") String expectStatus) {
    LOGGER.info("sayHello called, name = {}, index = {}, expectStatus = {}", name, index, expectStatus);
    return "from " + serverName + ": Hello, " + name;
  }
}
