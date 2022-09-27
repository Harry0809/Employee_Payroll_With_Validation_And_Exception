package com.example.lombook.Repository;

import com.example.lombook.Model.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeData, Integer> {

    List<EmployeeData> findDataByDepartment(String department);
}
