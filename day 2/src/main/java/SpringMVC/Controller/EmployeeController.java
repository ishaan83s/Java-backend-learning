package SpringMVC.Controller;

import SpringMVC.Entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmployeeController {
    //Temporary Database
    private List<Employee>employeeList = newArrayList<>();
    public String registerEmployee()

    public List<Employee>getAllEmployees()
        @GetMapping({"/id"})
        public Employee getEmployeeById(@PathVariable int id){
            for(Employee emp:employeeList){
                if(emp.getId() == id){
                    return emp;
                }
            }
            return null;
        }

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
