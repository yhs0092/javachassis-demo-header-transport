package com.github.yhs0092.hello.jaxrs;

import javax.servlet.http.Part;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class AggregatedParam {
  @PathParam("pathParam")
  private String pathParam;

  private String queryParam;

//  @QueryParam("complex")
//  private AggregatedParam complex;

//  public AggregatedParam getComplex() {
//    return complex;
//  }
//
//  public AggregatedParam setComplex(AggregatedParam complex) {
//    this.complex = complex;
//    return this;
//  }

  @DefaultValue("keke")
  @HeaderParam(value = "headerParam233")
  private String headerParam;

  @CookieParam("intVal")
  private int intVal;

  @FormParam("longVal")
  private long longVal;

  private Part uploaded;

  public String getPathParam() {
    return pathParam;
  }

  public AggregatedParam setPathParam(String pathParam) {
    this.pathParam = pathParam;
    return this;
  }

  public String getQ() {
    return queryParam;
  }

  @DefaultValue("QQ")
  @QueryParam(value = "queryParam")
  public AggregatedParam setQ(String queryParam) {
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

  public int getIntVal() {
    return intVal;
  }

  public AggregatedParam setIntVal(int intVal) {
    this.intVal = intVal;
    return this;
  }

  public long getLongVal() {
    return longVal;
  }

  public AggregatedParam setLongVal(long longVal) {
    this.longVal = longVal;
    return this;
  }

  public Part getUploaded() {
    return uploaded;
  }

  @FormParam("up")
  public AggregatedParam setUploaded(Part uploaded) {
    this.uploaded = uploaded;
    return this;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("AggregatedParam{");
    sb.append("pathParam='").append(pathParam).append('\'');
    sb.append(", queryParam='").append(queryParam).append('\'');
    sb.append(", headerParam='").append(headerParam).append('\'');
    sb.append(", intVal=").append(intVal);
    sb.append(", longVal=").append(longVal);
    sb.append(", uploaded=").append(uploaded);
    sb.append('}');
    return sb.toString();
  }
}
