package com.github.yhs0092.client;

public class HelloParam {
  private Integer index;

  private String expectStatus;

  private String name;

  public Integer getIndex() {
    return index;
  }

  public HelloParam setIndex(Integer index) {
    this.index = index;
    return this;
  }

  public String getExpectStatus() {
    return expectStatus;
  }

  public HelloParam setExpectStatus(String expectStatus) {
    this.expectStatus = expectStatus;
    return this;
  }

  public String getName() {
    return name;
  }

  public HelloParam setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("HelloParam{");
    sb.append("index=").append(index);
    sb.append(", expectStatus='").append(expectStatus).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
