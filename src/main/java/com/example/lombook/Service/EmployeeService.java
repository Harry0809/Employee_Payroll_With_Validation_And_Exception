package com.example.lombook.Service;

import com.example.lombook.Dto.EmployeeDto;
import com.example.lombook.Dto.ResponseDto;
import com.example.lombook.ExceptionHandling.EmployeeException;
import com.example.lombook.Model.EmployeeData;
import com.example.lombook.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService implements IEmployeeService {


    @Autowired
    EmployeeRepo employeeRepo;

    public List<EmployeeData> display() {
        return employeeRepo.findAll();
    }

    public Object saveAll(EmployeeDto employeeDto) {
        EmployeeData employeeData = new EmployeeData(employeeDto);
        return employeeRepo.save(employeeData);
    }

    public EmployeeData findById(int id) {
        return employeeRepo.findById(id).orElseThrow(() -> new EmployeeException("Employee id : " + id + "is not founded"));
    }

    public EmployeeData updateById(int id, EmployeeDto employeeDto) {
        Optional<EmployeeData> employeeData = employeeRepo.findById(id);
        if (employeeData.isPresent()) {
            employeeData.get().setFirstName(employeeDto.getFirstName());
            employeeData.get().setLastName(employeeDto.getLastName());
            employeeData.get().setGender(employeeDto.getGender());
            employeeData.get().setMessage(employeeDto.getMessage());
            employeeData.get().setGender(employeeDto.getGender());
            employeeData.get().setSalary(employeeDto.getSalary());
            employeeData.get().setJoiningDate(employeeDto.getJoiningDate());
            employeeRepo.save(employeeData.get());
            return employeeData.get();
        } else {
            throw new EmployeeException("Employee data with id: " + id + " is not founded");
        }
    }

    public Boolean deleteById(int id) {
        Optional<EmployeeData> employeeID = employeeRepo.findById(id);
        if (employeeID.isPresent()) {
            employeeRepo.deleteById(id);
            return true;
        } else {
            throw new EmployeeException("Id is not present in data");
        }
    }

    public List<EmployeeData> getDataByDepartment(String department){
        List<EmployeeData> employeeData = employeeRepo.findDataByDepartment(department);
        if (employeeData.isEmpty()){
            throw new EmployeeException("Department not founded");
        }else{
            return employeeData;
        }
    }
}