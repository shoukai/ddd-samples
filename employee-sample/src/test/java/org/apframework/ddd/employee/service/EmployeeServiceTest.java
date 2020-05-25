package org.apframework.ddd.employee.service;

import org.apframework.ddd.employee.Application;
import org.apframework.ddd.employee.domain.entity.EmployeeEntity;
import org.apframework.ddd.employee.domain.repository.mapper.EmployeeMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
@AutoConfigureTestDatabase
public class EmployeeServiceTest {

    private EmployeeMapper employeeMapper;

    @Before
    public void setUp() throws Exception {
        employeeMapper = Mockito.mock(EmployeeMapper.class);
    }

    @Test
    public void whenUserIdIsProvidedThenRetrievedNameIsCorrect() {
        Mockito.when(employeeMapper.selectById(1L)).thenReturn(EmployeeEntity.builder().id(1L).name("MockName").email("email@mock.org").age(19).build());
        EmployeeEntity employeeEntity = employeeMapper.selectById(1L);
        Assert.assertEquals("MockName", employeeEntity.getName());
    }

}
