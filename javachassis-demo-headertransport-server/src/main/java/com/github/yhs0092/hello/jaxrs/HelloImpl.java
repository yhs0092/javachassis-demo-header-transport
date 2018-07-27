package com.github.yhs0092.hello.jaxrs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.http.Part;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.github.yhs0092.hello.Hello;

@RestSchema(schemaId = "paramTransportTest")
@Path(value = "/params")
@Produces(MediaType.APPLICATION_JSON)
public class HelloImpl implements Hello {
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloImpl.class);

  @Value("${server.name}")
  private String serverName;

  //  @Path("/{pathParam}/test")
//  @POST
  @Override
  public String sayHello(
      @PathParam("pathParam") String pathParam,
      @DefaultValue("qp") @QueryParam(value = "queryParam") String queryParam,
      @HeaderParam(value = "headerParam") String headerParam,
      String bodyParam) {
    LOGGER.info("pathParam = {}, queryParam = {}, headerParam = {}, bodyParam = {}",
        pathParam, queryParam, headerParam, bodyParam);
    return "pathParam = [" + pathParam + "], queryParam = [" + queryParam + "], headerParam = [" + headerParam
        + "], bodyParam = [" + bodyParam + "]";
  }

  //  @Path("/upload")
//  @Consumes(MediaType.MULTIPART_FORM_DATA)
//  @POST
  public String upload(@FormParam("up") Part uploadFile) {
    LOGGER.info("upload is called");
    StringBuilder sb = new StringBuilder();
    try (
        InputStream uploadFileInputStream = uploadFile.getInputStream();
        Scanner scanner = new Scanner(uploadFileInputStream)
    ) {
      while (scanner.hasNextLine()) {
        sb.append(scanner.next()).append(System.lineSeparator());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    final String uploadContent = sb.toString();
    LOGGER.info("upload is done, content is [{}]", uploadContent);
    return uploadContent;
  }

  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Path("/{pathParam}/aggregate")
  @POST
  public String sayHelloAggregate(@BeanParam AggregatedParam aggregatedParam, @QueryParam("qqq") String bodyParam) {
    LOGGER.info("sayHelloAggregate is called, aggregatedParam = [{}], bodyParam = [{}]", aggregatedParam, bodyParam);
    return aggregatedParam + bodyParam;
  }
}
