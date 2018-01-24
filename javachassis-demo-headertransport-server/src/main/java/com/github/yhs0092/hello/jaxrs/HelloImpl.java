package com.github.yhs0092.hello.jaxrs;

import javax.ws.rs.BeanParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
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

@RestSchema(schemaId = "paramTransportTest")
@Path(value = "/params")
@Produces(MediaType.APPLICATION_JSON)
public class HelloImpl implements Hello {
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloImpl.class);

  @Value("${server.name}")
  private String serverName;

  @Path("/{pathParam}/test")
  @POST
  @Override
  public String sayHello(
      @PathParam("pathParam") String pathParam,
      @QueryParam(value = "queryParam") String queryParam,
      @HeaderParam(value = "headerParam") String headerParam,
      @BeanParam String bodyParam) {
    LOGGER.info("pathParam = {}, queryParam = {}, headerParam = {}, bodyParam = {}",
        pathParam, queryParam, headerParam, bodyParam);
    return "pathParam = [" + pathParam + "], queryParam = [" + queryParam + "], headerParam = [" + headerParam
        + "], bodyParam = [" + bodyParam + "]";
  }
}
