package org.apframework.ddd.employee.domain.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apframework.ddd.employee.domain.entity.EmployeeEntity;
import org.apframework.ddd.employee.domain.vo.EmployeeSkill;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<EmployeeEntity> {

    int saveEmployeeSkillList(List<EmployeeSkill> skillList);

}