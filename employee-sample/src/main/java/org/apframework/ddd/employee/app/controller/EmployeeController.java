package org.apframework.ddd.employee.app.controller;

import org.apframework.ddd.employee.app.controller.dto.response.EmployeeEntryResponseDTO;
import org.apframework.ddd.employee.domain.dto.EmployeeEntryDTO;
import org.apframework.ddd.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 域名路径规划，employee 代表员工相关内容
@RequestMapping("/api/v1/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "employee", method = RequestMethod.POST)
    public EmployeeEntryResponseDTO entry(@RequestBody EmployeeEntryDTO employeeEntry) {
        // 验证 employeeEntry 格式，是否完整，手机号是否正确……
        return new EmployeeEntryResponseDTO(employeeService.entry(employeeEntry));
    }

}
