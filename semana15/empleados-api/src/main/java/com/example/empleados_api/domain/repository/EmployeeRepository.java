package com.example.empleados_api.domain.repository;

import com.example.empleados_api.domain.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Employee save(Employee employee);

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    void deleteById(Long id);
}
