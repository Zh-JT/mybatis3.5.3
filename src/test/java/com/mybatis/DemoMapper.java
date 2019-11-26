package com.mybatis;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DemoMapper {

  List<HashMap<String,Object>> selectAll(Map<String,Object> map);
}
