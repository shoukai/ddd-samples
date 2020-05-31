package org.apframework.ddd.employee.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 与员工实体无关，作为技能管理使用
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillEntity {
    private Long id;
    private String category;
    private String name;
}
