package dev.micfro.weeklyquikclyapp.controller;

import dev.micfro.weeklyquikclyapp.model.Employee;

import dev.micfro.weeklyquikclyapp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    private List<Employee> employees;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

//        List<Employee> startEmployees = new ArrayList<>();

//        Employee newEmployee = new Employee(
//                "Thom", "Gold", "thom@gold.com", false, "ABCD1234!",
//                "Germany", "Berlin", "10001", "Breslauer Platz", 123,
//                "9876543210", LocalDate.of(1990, 5, 15),
//                "https://source.unsplash.com/random/100x100/?person",
//                "The first Employee", "Finance Manager", "Weekly Park",
//                "2024-03-11", true, 75000.0, "Finance", "Finance"
//        );

//        startEmployees.add(newEmployee);
//
//        // Save the list of  as employees to the database
//        for (Employee startEmployee : startEmployees) {
//            employeeService.saveEmployee(startEmployee);
//        }

//        employeeService.saveEmployee(newEmployee);

        this.employees = employeeService.getAllEmployees();
    }


    // Trim down to null. IMPORTANT
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

// Show the list of employees
    @GetMapping("/employee-list")
    public String displayEmployeeList(Model model) {
        model.addAttribute("employees", employees);
        return "employee/employee-list";
    }

//  show the form for adding a new employee
    @GetMapping("/employee-form")
    public String displayEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/employee-form";
    }

//   process the form for adding a new employee
    @PostMapping("/process-employee-form")
    public String processEmployeeForm(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "employee/employee-form";

        } else {
            // Save the new employee
            employeeService.saveEmployee(employee);

            // Retrieve the updated list of employees
            this.employees = employeeService.getAllEmployees();

            if (!employees.isEmpty()) {
                Employee lastEmployee = employees.get(employees.size() - 1);
                model.addAttribute("lastEmployee", lastEmployee);
            }

            return "employee-success";
        }
    }









    //     update employee
    @GetMapping("/employee-update")
    public String updateEmployee(@RequestParam("employeeId") Long employeeId, Model model) {
        Employee employee = employeeService.getEmployee(employeeId);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    // delete employee
    @GetMapping("/employee-delete")
    public String deleteEmployee(@RequestParam("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        this.employees = employeeService.getAllEmployees();
        return "redirect:/employee-list";
    }

}
