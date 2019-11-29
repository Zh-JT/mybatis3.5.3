package com.mybatis;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @Author: 张惊涛 on 2019/11/28 15:22
 * @Description:
 */
public class UserVo implements Serializable {

  private Integer id;

  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



}
