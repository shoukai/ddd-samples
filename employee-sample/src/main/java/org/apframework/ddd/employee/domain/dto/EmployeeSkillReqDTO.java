package org.apframework.ddd.employee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSkillReqDTO {
    /**
     * 技能
     */
    @NotNull(message = "Skill Id 不能为空")
    private Long skillId;
    /**
     * 技能级别
     */
    @NotNull(message = "Skill Level 不能为空")
    private Long skillLevelId;
}
