package org.apframework.ddd.employee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntryDTO {

    /**
     * 姓名
     */
    @NotNull(message = "员工姓名不能为空")
    private String name;

    /**
     * 年龄
     */
    @NotNull(message = "员工年龄不能为空")
    private Integer age;

    /**
     * 邮件
     */
    @NotBlank(message = "员工邮件不能为空")
    private String email;

    /**
     * 技能列表，仅包含id（技能id和技能级别id），可以为无技能
     */
    private List<EmployeeSkillReqDTO> employeeSkills;
}
