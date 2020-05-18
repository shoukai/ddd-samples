package org.apframework.ddd.employee.service;

import org.apframework.ddd.employee.domain.Employee;
import org.apframework.ddd.employee.domain.WorkLog;
import org.apframework.ddd.employee.domain.dto.EmployeeEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final Employee employee;

    public EmployeeService(Employee employee) {
        this.employee = employee;
    }

    public Integer entry(EmployeeEntryDTO employeeEntry) {
        employee.check(employeeEntry.getIdCard());
        Integer id = employee.entry(employeeEntry);
        employee.addSkillList(employeeEntry.getSkillSet());
        // ……

        WorkLog log = new WorkLog();
        //员工项目变更事件
        return id;
    }

}
