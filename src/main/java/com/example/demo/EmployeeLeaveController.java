
package com.example.demo;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeLeaveController {

    private final EmployeeLeaveService employeeLeaveService;

    public EmployeeLeaveController(
            EmployeeLeaveService employeeLeaveService) {
        this.employeeLeaveService = employeeLeaveService;
    }

    // Apply for leave
    @PostMapping("/leave")
    public ResponseEntity<String> applyLeave(
            @Valid @RequestBody EmployeeLeave leave) {

        String response =
                employeeLeaveService.applyLeave(leave);

        return ResponseEntity.ok(response);
    }

    // View all leave applications
    @GetMapping("/leaves")
    public ResponseEntity<List<EmployeeLeave>> getAllLeaves() {
        return ResponseEntity.ok(
                employeeLeaveService.getAllLeaves());
    }

    // View leave applications by employee ID
    @GetMapping("/{employeeId}/leave")
    public ResponseEntity<List<EmployeeLeave>> getLeavesByEmployeeId(
            @PathVariable int employeeId) {

        List<EmployeeLeave> leaves =
                employeeLeaveService.getLeavesByEmployeeId(employeeId);

        if (leaves.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(leaves);
    }
}
