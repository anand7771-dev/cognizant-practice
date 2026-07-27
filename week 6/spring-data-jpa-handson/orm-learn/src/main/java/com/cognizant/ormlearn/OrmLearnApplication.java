package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.AttemptService;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {

        // Hands-on 2
        testGetAllPermanentEmployees();

        // Hands-on 3
        testGetAttemptDetails();

        // Hands-on 4
        testGetAverageSalary();

        // Hands-on 5
        testGetAllEmployeesNative();
    }

    // ==================================================
    // HANDS-ON 2
    // Get all permanent employees using HQL
    // ==================================================

    private void testGetAllPermanentEmployees() {

        System.out.println("\n========================================");
        System.out.println("     ALL PERMANENT EMPLOYEES - HQL");
        System.out.println("========================================");

        List<Employee> employeeList =
                employeeService.getAllPermanentEmployees();

        for (Employee employee : employeeList) {

            System.out.println("\nEmployee Details");
            System.out.println("------------------------------");

            System.out.println("ID         : " + employee.getId());
            System.out.println("Name       : " + employee.getName());
            System.out.println("Salary     : " + employee.getSalary());
            System.out.println("Permanent  : " + employee.isPermanent());
            System.out.println("DOB        : " + employee.getDateOfBirth());

            if (employee.getDepartment() != null) {
                System.out.println(
                        "Department : "
                        + employee.getDepartment().getName()
                );
            }

            System.out.println("Skills:");

            if (employee.getSkillList() != null) {
                employee.getSkillList().forEach(
                        skill -> System.out.println(
                                "  - " + skill.getName()
                        )
                );
            }
        }

        System.out.println("========================================");
    }

    // ==================================================
    // HANDS-ON 3
    // Fetch Quiz Attempt Details
    // ==================================================

    private void testGetAttemptDetails() {

        System.out.println("\n========================================");
        System.out.println("          QUIZ ATTEMPT DETAILS");
        System.out.println("========================================");

        int attemptId = 1;

        Attempt attempt = attemptService.getAttempt(attemptId);

        if (attempt == null) {
            System.out.println("Attempt not found.");
            System.out.println("========================================");
            return;
        }

        System.out.println("Attempt ID : " + attempt.getId());

        if (attempt.getUser() != null) {
            System.out.println("User       : "
                    + attempt.getUser().getName());
        }

        System.out.println("Date       : " + attempt.getDate());
        System.out.println("Score      : " + attempt.getScore());

        List<AttemptQuestion> questions =
                attemptService.getAttemptQuestions(attemptId);

        for (AttemptQuestion attemptQuestion : questions) {

            System.out.println();
            System.out.println("----------------------------------------");

            if (attemptQuestion.getQuestion() != null) {
                System.out.println(
                        "Question : "
                        + attemptQuestion.getQuestion().getText()
                );
            }

            List<AttemptOption> selectedOptions =
                    attemptService.getSelectedOptions(
                            attemptQuestion.getId()
                    );

            if (selectedOptions.isEmpty()) {
                System.out.println("Selected Answer : No answer selected");
            } else {

                for (AttemptOption attemptOption : selectedOptions) {

                    if (attemptOption.getOption() != null) {

                        System.out.println(
                                "Selected Answer : "
                                + attemptOption.getOption().getText()
                        );

                        System.out.println(
                                "Correct         : "
                                + attemptOption.getOption().getCorrect()
                        );
                    }
                }
            }
        }

        System.out.println("----------------------------------------");
        System.out.println("========================================");
    }

    // ==================================================
    // HANDS-ON 4
    // Get average salary using HQL
    // ==================================================

    private void testGetAverageSalary() {

        System.out.println("\n========================================");
        System.out.println("       AVERAGE SALARY - HQL");
        System.out.println("========================================");

        int departmentId = 1;

        Double averageSalary =
                employeeService.getAverageSalary(departmentId);

        System.out.println("Department ID  : " + departmentId);
        System.out.println("Average Salary : " + averageSalary);

        System.out.println("========================================");
    }

    // ==================================================
    // HANDS-ON 5
    // Get all employees using Native Query
    // ==================================================

    private void testGetAllEmployeesNative() {

        System.out.println("\n========================================");
        System.out.println("     ALL EMPLOYEES - NATIVE QUERY");
        System.out.println("========================================");

        List<Employee> employeeList =
                employeeService.getAllEmployeesNative();

        for (Employee employee : employeeList) {

            System.out.println(
                    "ID: " + employee.getId()
                    + " | Name: " + employee.getName()
                    + " | Salary: " + employee.getSalary()
                    + " | Permanent: " + employee.isPermanent()
            );
        }

        System.out.println("========================================");
    }
}