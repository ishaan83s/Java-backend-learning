package SpringMVC.Controller;

import SpringMVC.Entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList; // FIXED: Added this so Java knows what an ArrayList is
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    // Temporary In-Memory Database
    private List<Employee> employeeList = new ArrayList<>();

    // 1. WELCOME
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Employee Management System!";
    }

    // 2. CREATE (Register an employee)
    @PostMapping("/register")
    public String registerEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return "Employee Registered Successfully";
    }

    // 3. READ ALL (Get everyone)
    @GetMapping
    public List<Employee> getAllEmployees() { // FIXED: Added the missing method body
        return employeeList;
    }

    // 4. READ ONE (Get by specific ID)
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") int employeeid) {
        for (Employee emp : employeeList) {
            if (emp.getId() == employeeid) {
                return emp;
            }
        }
        return null; // Returns nothing if ID doesn't exist
    }

    // 5. SEARCH (Filter by query param, e.g., /search?department=HR)
    @GetMapping("/search")
    public Employee searchEmployee(@RequestParam(required = false) String department) {
        for (Employee emp : employeeList) {
            if (emp.getDepartment().equalsIgnoreCase(department)) {
                return emp;
            }
        }
        return null;
    }

    // 6. UPDATE (Modify an existing employee)
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee updateemployee) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                emp.setName(updateemployee.getName());
                emp.setDepartment(updateemployee.getDepartment());
                emp.setSalary(updateemployee.getSalary());
                return "Employee Updated Successfully"; // FIXED: Added mandatory return statement
            }
        }
        return "Employee Not Found"; // FIXED: Handles case where ID doesn't exist
    }

    // 7. DELETE (Remove an employee)
    @DeleteMapping("/{id}") // FIXED: Added correct annotation and fixed typo
    public String deleteEmployee(@PathVariable int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                employeeList.remove(emp);
                return "Employee Deleted Successfully";
            }
        }
        return "Employee Not Found";
    }
}