package SpringMVC.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmployeeController {
    public String registerEmployee()

    public List<Employee>getAllEmployees()
    public Employee getEmployeeById()
    public Employee setEmployee()
    public String updateEmployee()
    public String deleteEmployee()


    //Welcome API
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome To Employee Management System";
    }
}
