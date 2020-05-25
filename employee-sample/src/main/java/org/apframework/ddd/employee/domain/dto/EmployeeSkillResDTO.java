package org.apframework.ddd.employee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSkillResDTO {
    private Long skillId;
    private String skillCategory;
    private String skillName;
    private Long skillLevelId;
    private String skillLevelName;
    private String skillLevelRequirement;
}
