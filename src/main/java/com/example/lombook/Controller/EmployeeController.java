package com.example.lombook.Controller;

import com.example.lombook.Dto.EmployeeDto;
import com.example.lombook.Dto.ResponseDto;
import com.example.lombook.Model.EmployeeData;
import com.example.lombook.Service.EmployeeService;
import com.example.lombook.Service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;

    List<EmployeeData> list = new ArrayList<>();

    //Save Data
    @PostMapping("/save")
    public ResponseEntity<ResponseDto> save(@Valid @RequestBody EmployeeDto employeeDto) {
        ResponseDto responseDto = new ResponseDto("data saved", iEmployeeService.saveAll(employeeDto));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/data")
    public ResponseEntity<ResponseDto> displayAll() {
        ResponseDto responseDto = new ResponseDto("Data displayed", iEmployeeService.display());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable int id) {
        EmployeeData employeeData = iEmployeeService.findById(id);
        ResponseDto responseDto = new ResponseDto("Employee data founded" , employeeData);
        return new ResponseEntity<ResponseDto>(responseDto , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable int id) {
        Boolean isEmpId = iEmployeeService.deleteById(id);
        String message = isEmpId ? "ID deleted successfully" : "ID not founded";
        ResponseDto responseDto = new ResponseDto(message);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto, @PathVariable int id) {
        EmployeeData newEmployee = iEmployeeService.updateById(id, employeeDto);
        ResponseDto responseDto = new ResponseDto("Employee data updated: ", newEmployee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/find/{department}")
    public ResponseEntity<ResponseDto> getDataByDepartment(@PathVariable String department){
        List<EmployeeData> employeeDataList;
        employeeDataList= iEmployeeService.getDataByDepartment(department);
        ResponseDto responseDto = new ResponseDto("Data founded by department succesfully" , employeeDataList);
        return new ResponseEntity<>(responseDto , HttpStatus.OK);
    }


}

