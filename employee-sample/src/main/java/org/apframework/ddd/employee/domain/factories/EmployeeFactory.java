package org.apframework.ddd.employee.domain.factories;

import org.apframework.ddd.employee.domain.entity.EmployeeEntity;

public class EmployeeFactory {

    public static EmployeeEntity withName(String name) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(name);
        return employee;
    }

    // …… 其他 build

}
