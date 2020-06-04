package org.apframework.ddd.employee.domain;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.apframework.ddd.employee.domain.dto.EmployeeDTO;
import org.apframework.ddd.employee.domain.dto.EmployeeEntryDTO;
import org.apframework.ddd.employee.domain.dto.EmployeeSummaryDTO;
import org.apframework.ddd.employee.domain.entity.EmployeeEntity;
import org.apframework.ddd.employee.domain.factories.EmployeeFactory;
import org.apframework.ddd.employee.domain.dto.EmployeeSkillResDTO;
import org.apframework.ddd.employee.domain.repository.mapper.EmployeeMapper;
import org.apframework.ddd.employee.domain.vo.EmployeeSkill;
import org.apframework.ddd.employee.infrastructure.exception.BizException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public EmployeeDTO getById(Long id) {
        EmployeeEntity employeeEntity = employeeMapper.selectById(id);
        if (employeeEntity == null) {
            log.warn("获取员工信息失败，员工id：{}", id);
            return null;
        }
        EmployeeDTO employee = EmployeeDTO.builder()
                .id(id)
                .email(employeeEntity.getEmail())
                .name(employeeEntity.getName()).build();
        List<EmployeeSkill> skills = employeeMapper.getEmployeeSkillListByEmployeeId(id);
        if (skills == null) {
            employee.setSkills(Lists.newArrayList());
        } else {
            employee.setSkills(skills.stream().map(
                    p -> new EmployeeSkillResDTO(
                            p.getSkillId(), p.getSkillCategory(), p.getSkillName(),
                            p.getSkillLevelId(), p.getSkillLevelName(), p.getSkillLevelRequirement()
                    )
            ).collect(Collectors.toList()));
        }
        return employee;
    }

    public EmployeeSummaryDTO getSummaryById(Long id) {
        EmployeeEntity employeeEntity = employeeMapper.selectById(id);
        if (employeeEntity == null) {
            log.warn("获取员工信息失败，员工id：{}", id);
            return null;
        }
        return EmployeeSummaryDTO.builder()
                .email(employeeEntity.getEmail())
                .id(employeeEntity.getId())
                .name(employeeEntity.getName())
                .build();
    }
}
