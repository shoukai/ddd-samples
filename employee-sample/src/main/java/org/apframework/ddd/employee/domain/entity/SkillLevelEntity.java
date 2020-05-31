package org.apframework.ddd.employee.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 与员工实体无关，作为技能级别管理使用
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillLevelEntity {
    private Long id;
    private Long skillId;
    private String name;
    private String requirement;
}
