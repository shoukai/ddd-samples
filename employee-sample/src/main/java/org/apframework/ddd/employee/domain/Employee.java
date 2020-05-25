package org.apframework.ddd.employee.domain;

import lombok.Builder;
import org.apframework.ddd.employee.domain.dto.EmployeeEntryDTO;
import org.apframework.ddd.employee.domain.entity.EmployeeEntity;
import org.apframework.ddd.employee.domain.factories.EmployeeFactory;
import org.apframework.ddd.employee.domain.dto.EmployeeSkillResDTO;
import org.apframework.ddd.employee.domain.repository.mapper.EmployeeMapper;
import org.apframework.ddd.employee.domain.vo.EmployeeSkill;
import org.apframework.ddd.employee.infrastructure.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Builder
public class Employee {

    @Autowired
    private EmployeeMapper employeeMapper;

    public String createEmployee() {
        // employeeMapper save
        // notify department
        return "id";
    }

    public void removeEmployee() {
        // 员工离职
        // notify employee add done
    }

    public void addSkill(EmployeeSkillResDTO employeeSkillResDTO) {
    }

    public void check(String idCard) {
    }

    @Transactional
    public Long entry(EmployeeEntryDTO employeeEntryDTO) {
        // 创建者
        EmployeeEntity employeeEntity = EmployeeFactory.with(employeeEntryDTO);
        int result = employeeMapper.insert(employeeEntity);
        if (result < 1) {
            throw new BizException("存储失败");
        }
        List<EmployeeSkill> employeeSkillList= EmployeeFactory.withSkill(employeeEntity.getId(), employeeEntryDTO);
        employeeMapper.saveEmployeeSkillList(employeeSkillList);

        // MAPPER SAVE
        // RETURN ID;
        // notify employee add done
        return employeeEntity.getId();
    }
}
