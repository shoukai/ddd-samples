package org.apframework.ddd.employee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apframework.ddd.employee.domain.vo.LanguageSet;
import org.apframework.ddd.employee.domain.vo.ProjectExperience;
import org.apframework.ddd.employee.domain.vo.SkillSet;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntryDTO {

    @NotNull(message = "员工姓名不能为空")
    private String name;
    @NotNull(message = "身份证ID不能为空")
    private String idCard;
    //……
    private SkillSet skillSet;
    //……
    private LanguageSet languageSet;
    //……
    private ProjectExperience projectExperience;
}
