package com.github.yhs0092.client;

public class HelloParam {
  private String pathParam;

  private String queryParam;

  private String headerParam;

  private String bodyParam;

  public String getPathParam() {
    return pathParam;
  }

  public HelloParam setPathParam(String pathParam) {
    this.pathParam = pathParam;
    return this;
  }

  public String getQueryParam() {
    return queryParam;
  }

  public HelloParam setQueryParam(String queryParam) {
    this.queryParam = queryParam;
    return this;
  }

  public String getHeaderParam() {
    return headerParam;
  }

  public HelloParam setHeaderParam(String headerParam) {
    this.headerParam = headerParam;
    return this;
  }

  public String getBodyParam() {
    return bodyParam;
  }

  public HelloParam setBodyParam(String bodyParam) {
    this.bodyParam = bodyParam;
    return this;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("HelloParam{");
    sb.append("pathParam='").append(pathParam).append('\'');
    sb.append(", queryParam='").append(queryParam).append('\'');
    sb.append(", headerParam='").append(headerParam).append('\'');
    sb.append(", bodyParam='").append(bodyParam).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
