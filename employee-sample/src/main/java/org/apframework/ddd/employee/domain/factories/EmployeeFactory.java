package org.apframework.ddd.employee.domain.factories;

import org.apframework.ddd.employee.domain.dto.EmployeeEntryDTO;
import org.apframework.ddd.employee.domain.dto.EmployeeSkillReqDTO;
import org.apframework.ddd.employee.domain.entity.EmployeeEntity;
import org.apframework.ddd.employee.domain.vo.EmployeeSkill;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFactory {

    public static EmployeeEntity with(EmployeeEntryDTO employeeEntry) {
        return EmployeeEntity.builder()
                .age(employeeEntry.getAge())
                .email(employeeEntry.getEmail())
                .name(employeeEntry.getName())
                .build();
    }

    public static List<EmployeeSkill> withSkill(Long id, EmployeeEntryDTO employeeEntry) {
        if (employeeEntry == null || employeeEntry.getEmployeeSkills() == null) {
            return null;
        }
        return employeeEntry.getEmployeeSkills()
                .stream()
                .map(p -> buildEmployeeSkill(id, p))
                .collect(Collectors.toList());
    }

    private static EmployeeSkill buildEmployeeSkill(Long id, EmployeeSkillReqDTO employeeSkill) {
        return new EmployeeSkill(id, employeeSkill.getSkillId(), employeeSkill.getSkillLevelId());
    }

}
