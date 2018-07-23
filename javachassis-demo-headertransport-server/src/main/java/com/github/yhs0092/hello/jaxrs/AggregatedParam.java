package com.github.yhs0092.hello.jaxrs;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class AggregatedParam {
  @PathParam("pathParam")
  private String pathParam;

  private String queryParam;

  @HeaderParam(value = "headerParam")
  private String headerParam;

  public String getPathParam() {
    return pathParam;
  }

  public AggregatedParam setPathParam(String pathParam) {
    this.pathParam = pathParam;
    return this;
  }

  public String getQueryParam() {
    return queryParam;
  }

  @QueryParam(value = "queryParam")
  public AggregatedParam setQueryParam(String queryParam) {
    this.queryParam = queryParam;
    return this;
  }

  public String getHeaderParam() {
    return headerParam;
  }

  public AggregatedParam setHeaderParam(String headerParam) {
    this.headerParam = headerParam;
    return this;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("AggregatedParam{");
    sb.append("pathParam='").append(pathParam).append('\'');
    sb.append(", queryParam='").append(queryParam).append('\'');
    sb.append(", headerParam='").append(headerParam).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
