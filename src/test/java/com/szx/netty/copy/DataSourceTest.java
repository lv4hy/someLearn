package com.szx.netty.copy;

import com.szx.netty.ApplicationMy;
import com.szx.netty.bean.Student;
import com.szx.netty.dao.FirstMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ApplicationMy.class)
@RunWith(SpringRunner.class)
public class DataSourceTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void dataSourceTest(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            FirstMapper mapper = session.getMapper(FirstMapper.class);
            Student student = mapper.selectOneById(1);
            System.out.println(student.getName());
        }finally {
            session.close();
        }
    }
}
