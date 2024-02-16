package com.mycompany.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class CSVExportController {

    @RequestMapping("/download/employee.csv")
    public void downloadCSVFile(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition","attachment; file=employee.csv");
        downloadCSVFile(response.getWriter(),createDataTest());
    }

    public record Employee(Integer id, String firstName, String lastName) {};

    private List<Employee> createDataTest(){
        List<Employee> data = new ArrayList<>();
        data.add(new Employee(1,"Test Firstname 1", "Test Lastname 1"));
        data.add(new Employee(2,"Test Firstname 2", "Test Lastname 2"));
        data.add(new Employee(3,"Test Firstname 3", "Test Lastname 3"));
        data.add(new Employee(4,"Test Firstname 4", "Test Lastname 4"));
        data.add(new Employee(5,"Test Firstname 5", "Test Lastname 5"));
        return data;
    }

    private void downloadCSVFile(PrintWriter printWriter, List<Employee> employees) {
            printWriter.write("Employee ID, First Name, Last Name \n");
            for(Employee employee: employees){
                printWriter.write(employee.id()
                        + ", " +
                        employee.firstName()
                        + ", " +
                        employee.lastName()
                        + "\n"
                        );
            }
            printWriter.write("\n");
    }

}

