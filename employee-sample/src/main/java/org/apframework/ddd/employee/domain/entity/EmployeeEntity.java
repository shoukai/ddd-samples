package org.apframework.ddd.employee.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "e_employee", autoResultMap = true)
public class EmployeeEntity {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
