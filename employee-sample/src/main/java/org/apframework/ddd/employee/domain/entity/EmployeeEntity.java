package org.apframework.ddd.employee.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "employee", autoResultMap = true)
public class EmployeeEntity {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
