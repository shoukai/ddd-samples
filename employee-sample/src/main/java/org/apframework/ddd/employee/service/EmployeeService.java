package org.apframework.ddd.employee.service;

import org.apframework.ddd.employee.domain.Employee;
import org.apframework.ddd.employee.domain.dto.EmployeeEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private Employee employee;

    public Integer entry(EmployeeEntryDTO employeeEntry) {
        employee.check(employeeEntry.getIdCard());
        Integer id = employee.entry(employeeEntry);
        employee.addSkillList(employeeEntry.getSkillSet());
        // ……
        // notify employee add done
        return id;
    }

}
