package org.apframework.ddd.employee.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeSkill {

    public EmployeeSkill(Long employeeId, Long skillId, Long skillLevelId) {
        this.employeeId = employeeId;
        this.skillId = skillId;
        this.skillLevelId = skillLevelId;
    }

    private Long id;
    private Long employeeId;

    private Long skillId;
    private String skillCategory;
    private String skillName;

    private Long skillLevelId;
    private String skillLevelName;
    private String skillLevelRequirement;

}
