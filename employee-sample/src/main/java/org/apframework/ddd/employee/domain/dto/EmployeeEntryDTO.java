package org.apframework.ddd.employee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apframework.ddd.employee.domain.vo.LanguageSet;
import org.apframework.ddd.employee.domain.vo.ProjectExperience;
import org.apframework.ddd.employee.domain.vo.SkillSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntryDTO {

    private String name;
    private String idCard;

    private SkillSet skillSet;
    private LanguageSet languageSet;
    private ProjectExperience projectExperience;
}
