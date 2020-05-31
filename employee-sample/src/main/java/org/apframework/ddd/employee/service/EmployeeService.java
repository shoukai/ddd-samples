package org.apframework.ddd.employee.service;

import org.apframework.ddd.employee.domain.Employee;
import org.apframework.ddd.employee.domain.dto.EmployeeEntryDTO;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

/**
 * 员工应用服务
 */
@Service
public class EmployeeService {

    private final Employee employee;

    public EmployeeService(Employee employee) {
        this.employee = employee;
    }

    @Transient
    public Long entry(EmployeeEntryDTO employeeEntry) {
        Long id = employee.entry(employeeEntry);
        // ……

        //员工项目变更事件
        return id;
    }

}
