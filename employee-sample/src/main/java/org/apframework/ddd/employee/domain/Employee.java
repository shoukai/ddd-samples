package org.apframework.ddd.employee.domain;

import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.apframework.ddd.employee.domain.dto.EmployeeEntryDTO;
import org.apframework.ddd.employee.domain.entity.EmployeeEntity;
import org.apframework.ddd.employee.domain.factories.EmployeeFactory;
import org.apframework.ddd.employee.domain.dto.EmployeeSkillResDTO;
import org.apframework.ddd.employee.domain.repository.mapper.EmployeeMapper;
import org.apframework.ddd.employee.domain.vo.EmployeeSkill;
import org.apframework.ddd.employee.infrastructure.exception.BizException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 员工实体服务
 */
@Log4j2
@Service
@Builder
public class Employee {

    private final EmployeeMapper employeeMapper;

    public Employee(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }


    public void removeEmployee() {
        // 员工离职
        // notify employee add done
    }

    public void addSkill(EmployeeSkillResDTO employeeSkillResDTO) {
    }

    public void check(String idCard) {
    }

    /**
     * 员工入职
     *
     * @param employeeEntry 外部传输对象
     * @return 员工id
     */
    @Transactional
    public Long entry(EmployeeEntryDTO employeeEntry) {
        // 创建者
        EmployeeEntity employeeEntity = EmployeeFactory.with(employeeEntry);
        int result = employeeMapper.insert(employeeEntity);
        if (result < 1) {
            throw new BizException("存储失败");
        }
        List<EmployeeSkill> employeeSkillList = EmployeeFactory.withSkill(employeeEntity.getId(), employeeEntry);
        int count = employeeMapper.saveEmployeeSkillList(employeeSkillList);
        log.info("存储员工技能{}项", count);
        // todo notify employee add done
        return employeeEntity.getId();
    }
}
