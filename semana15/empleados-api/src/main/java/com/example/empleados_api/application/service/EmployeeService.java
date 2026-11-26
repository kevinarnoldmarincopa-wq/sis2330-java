package com.example.empleados_api.application.service;

import com.example.empleados_api.application.dto.EmployeeRequest;
import com.example.empleados_api.application.dto.EmployeeResponse;
import com.example.empleados_api.domain.entity.Employee;
import com.example.empleados_api.domain.entity.Salary;
import com.example.empleados_api.domain.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeResponse create(EmployeeRequest request) {
        Salary salary = new Salary(request.getSalary(), "BOB");

        Employee employee = new Employee(
            null,
            request.getName(),
            request.getEmail(),
            salary
        );

        return toResponse(repository.save(employee));
    }

    public List<EmployeeResponse> findAll() {
        return repository.findAll()
            .stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public EmployeeResponse findById(Long id) {
        Employee employee = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        return toResponse(employee);
    }

    public EmployeeResponse update(Long id, EmployeeRequest request) {
        Employee employee = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        Employee updated = new Employee(
            id,
            request.getName(),
            request.getEmail(),
            new Salary(request.getSalary(), "BOB")
        );

        return toResponse(repository.save(updated));
    }

    public void delete(Long id) {
        if (!repository.findById(id).isPresent()) {
            throw new RuntimeException("Empleado no encontrado");
        }

        repository.deleteById(id);
    }

    private EmployeeResponse toResponse(Employee employee) {
        return new EmployeeResponse(
            employee.getId(),
            employee.getName(),
            employee.getEmail(),
            employee.getSalary().getAmount()
        );
    }
}
