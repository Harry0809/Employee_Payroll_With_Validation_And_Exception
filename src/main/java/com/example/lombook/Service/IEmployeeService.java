package com.example.lombook.Service;

import com.example.lombook.Dto.EmployeeDto;
import com.example.lombook.Dto.ResponseDto;
import com.example.lombook.Model.EmployeeData;

import java.util.List;

public interface IEmployeeService {

    Object saveAll(EmployeeDto employeeDto);

    Object display();

    EmployeeData findById(int id);

    Boolean deleteById(int getId);

    EmployeeData updateById(int id, EmployeeDto employeeDto);

    List<EmployeeData> getDataByDepartment(String department);
}
