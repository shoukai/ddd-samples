package org.apframework.ddd.employee.app.controller;

import org.apframework.ddd.employee.app.controller.dto.response.EmployeeEntryResponseDTO;
import org.apframework.ddd.employee.domain.dto.EmployeeEntryDTO;
import org.apframework.ddd.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeEntryResponseDTO entry(@RequestBody EmployeeEntryDTO employeeEntry) {
        // 验证 employeeEntry 格式，是否完整，手机号是否正确……
        return new EmployeeEntryResponseDTO(employeeService.entry(employeeEntry));
    }

}
