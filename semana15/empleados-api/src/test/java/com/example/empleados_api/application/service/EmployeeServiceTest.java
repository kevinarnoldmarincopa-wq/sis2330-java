package com.example.empleados_api.application.service;

import com.example.empleados_api.application.dto.EmployeeRequest;
import com.example.empleados_api.application.dto.EmployeeResponse;
import com.example.empleados_api.domain.entity.Employee;
import com.example.empleados_api.domain.entity.Salary;
import com.example.empleados_api.domain.repository.EmployeeRepository;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Test
    void shouldCreateEmployee() {
        EmployeeRepository repository = mock(EmployeeRepository.class);

        Employee employee = new Employee(
            1L,
            "Kevin",
            "kevin@gmail.com",
            new Salary(3500, "BOB")
        );

        when(repository.save(any(Employee.class))).thenReturn(employee);

        EmployeeService service = new EmployeeService(repository);

        EmployeeRequest request = new EmployeeRequest();
        request.setName("Kevin");
        request.setEmail("kevin@gmail.com");
        request.setSalary(3500);

        EmployeeResponse response = service.create(request);

        assertEquals("Kevin", response.getName());
        assertEquals("kevin@gmail.com", response.getEmail());
        assertEquals(3500, response.getSalary());

        verify(repository).save(any(Employee.class));
    }

    @Test
    void shouldListEmployees() {
        EmployeeRepository repository = mock(EmployeeRepository.class);

        Employee employee = new Employee(
            1L,
            "Ana",
            "ana@gmail.com",
            new Salary(4000, "BOB")
        );

        when(repository.findAll()).thenReturn(List.of(employee));

        EmployeeService service = new EmployeeService(repository);

        List<EmployeeResponse> employees = service.findAll();

        assertEquals(1, employees.size());
        assertEquals("Ana", employees.get(0).getName());
    }
}
