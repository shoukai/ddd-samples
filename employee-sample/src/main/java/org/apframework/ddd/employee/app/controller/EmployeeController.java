package org.apframework.ddd.employee.app.controller;

import org.apframework.ddd.employee.app.controller.dto.response.EmployeeEntryResponseDTO;
import org.apframework.ddd.employee.domain.dto.EmployeeDTO;
import org.apframework.ddd.employee.domain.dto.EmployeeEntryDTO;
import org.apframework.ddd.employee.domain.dto.EmployeeSummaryDTO;
import org.apframework.ddd.employee.infrastructure.exception.BizException;
import org.apframework.ddd.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
// 域名路径规划，employee 代表员工相关内容
@RequestMapping("/api/v1/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 新增员工，员工入职
     */
    @RequestMapping(value = "employee", method = RequestMethod.POST)
    public EmployeeEntryResponseDTO entry(@Valid @RequestBody EmployeeEntryDTO employeeEntry) {
        // 验证 employeeEntry 格式，是否完整，手机号是否正确……
        return new EmployeeEntryResponseDTO(employeeService.entry(employeeEntry));
    }

    /**
     * 获取员工详情
     */
    @RequestMapping(value = "employee", method = RequestMethod.GET)
    public EmployeeDTO get(@RequestParam Long id) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            // 统一异常码框架封装待完善
            throw new BizException("未获取到指定员工");
        }
        return employee;
    }

    /**
     * 获取员工摘要信息
     */
    @RequestMapping(value = "summary", method = RequestMethod.GET)
    public EmployeeSummaryDTO getSummary(@RequestParam Long id) {
        EmployeeSummaryDTO employee = employeeService.getEmployeeSummaryById(id);
        if (employee == null) {
            // 统一异常码框架封装待完善
            throw new BizException("未获取到指定员工");
        }
        return employee;
    }

}
