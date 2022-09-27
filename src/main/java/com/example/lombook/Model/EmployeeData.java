package com.example.lombook.Model;

import com.example.lombook.Dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeData {

    String firstName;
    String lastName;
    String department;
    String gender;
    String message;
    Long salary;
    LocalDate joiningDate;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    public EmployeeData(String message) {
        this.message = message;
    }

    public EmployeeData(EmployeeDto employeeDto) {
        this.id = id;
        this.gender = employeeDto.getGender();
        this.department = employeeDto.getDepartment();
        this.message = employeeDto.getMessage();
        this.salary = employeeDto.getSalary();
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.joiningDate = employeeDto.getJoiningDate();
    }
}