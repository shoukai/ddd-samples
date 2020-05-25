package org.apframework.ddd.employee.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillLevel {
    private Long id;
    private Long skillId;
    private String name;
    private String requirement;
}
