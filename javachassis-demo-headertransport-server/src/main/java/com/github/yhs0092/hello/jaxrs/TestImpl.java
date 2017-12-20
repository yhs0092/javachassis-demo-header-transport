package com.github.yhs0092.hello.jaxrs;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.yhs0092.hello.EmptyParam;
import com.github.yhs0092.hello.Test;

import io.servicecomb.provider.rest.common.RestSchema;

@RestSchema(schemaId = "test")
@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestImpl implements Test {
  Logger LOGGER = LoggerFactory.getLogger(TestImpl.class);

  @Path("/emptyParam")
  @POST
  @Override
  public String test(EmptyParam param) {
    LOGGER.info("empty param is called");
    return "success";
  }
}
