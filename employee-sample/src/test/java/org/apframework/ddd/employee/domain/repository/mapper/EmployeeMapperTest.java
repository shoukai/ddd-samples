package org.apframework.ddd.employee.domain.repository.mapper;

import org.apframework.ddd.employee.domain.entity.EmployeeEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMapperTest {

    @Resource
    private EmployeeMapper employeeMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<EmployeeEntity> userList = employeeMapper.selectList(null);
        Assert.assertTrue(userList.size() >= 5);
        userList.forEach(System.out::println);
    }
}
