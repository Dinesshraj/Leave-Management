
package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeLeaveService {

    private final List<EmployeeLeave> leaveApplications =
            new ArrayList<>();

    public String applyLeave(EmployeeLeave leave) {
        leaveApplications.add(leave);

        return "Leave application submitted successfully! "
                + "Employee ID: " + leave.getEmployeeId()
                + ", Employee Name: " + leave.getEmployeeName()
                + ", Leave Type: " + leave.getLeaveType()
                + ", Number of Days: " + leave.getNumberOfDays()
                + ", Reason: " + leave.getReason();
    }

    public List<EmployeeLeave> getAllLeaves() {
        return new ArrayList<>(leaveApplications);
    }

    public List<EmployeeLeave> getLeavesByEmployeeId(int employeeId) {
        return leaveApplications.stream()
                .filter(leave ->
                        leave.getEmployeeId() == employeeId)
                .toList();
    }
}
