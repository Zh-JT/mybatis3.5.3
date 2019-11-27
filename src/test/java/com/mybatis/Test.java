package com.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

  public static void main(String[] args) throws IOException {
    String resource = "mybatis.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    /*从调用者角度来讲，与数据库打交道的对象SqlSession
     *通过动态代理 去帮我们执行SQL
     * */
    /*拿到一个动态代理后的Mapper*/
    DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
    Map<String,Object> map = new HashMap<>();
    map.put("id","1");
    List<HashMap<String, Object>> hashMaps = mapper.selectAll(map);
    System.out.println(hashMaps);
    sqlSession.close();
  }
}
