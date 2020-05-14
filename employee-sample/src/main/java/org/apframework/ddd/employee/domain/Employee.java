package org.apframework.ddd.employee.domain;

import org.apframework.ddd.employee.domain.dto.EmployeeEntryDTO;
import org.apframework.ddd.employee.domain.entity.EmployeeEntity;
import org.apframework.ddd.employee.domain.factories.EmployeeFactory;
import org.apframework.ddd.employee.domain.repository.EmployeeMapper;
import org.apframework.ddd.employee.domain.vo.Skill;
import org.apframework.ddd.employee.domain.vo.SkillSet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Employee {

    private EmployeeMapper employeeMapper;

    public String createEmployee() {
        // employeeMapper save
        // notify department
        return "id";
    }

    public void removeEmployee() {
        // 员工离职
    }

    public void addSkill(Skill skill) {
    }

    public void addSkillList(SkillSet skillSet) {
    }

    public void check(String idCard) {
    }

    public Integer entry(EmployeeEntryDTO employeeEntry) {
        // 创建者
        EmployeeEntity employeeEntity = EmployeeFactory.withName(employeeEntry.getName());
        // MAPPER SAVE
        // RETURN ID;
        return 1;
    }
}
