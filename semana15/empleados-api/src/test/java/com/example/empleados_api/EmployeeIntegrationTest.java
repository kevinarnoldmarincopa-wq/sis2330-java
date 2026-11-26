package com.example.empleados_api;

import com.example.empleados_api.application.dto.EmployeeRequest;
import com.example.empleados_api.application.dto.EmployeeResponse;
import com.example.empleados_api.presentation.controller.EmployeeController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeIntegrationTest {

    @Autowired
    private EmployeeController controller;

    @Test
    void shouldCreateAndListEmployee() {

        EmployeeRequest request = new EmployeeRequest();
        request.setName("Carlos");
        request.setEmail("carlos@gmail.com");
        request.setSalary(4500);

        EmployeeResponse created = controller.create(request);

        assertNotNull(created.getId());
        assertEquals("Carlos", created.getName());
        assertEquals(4500, created.getSalary());

        List<EmployeeResponse> employees = controller.findAll();

        assertFalse(employees.isEmpty());
        assertTrue(
            employees.stream()
                .anyMatch(employee -> employee.getEmail().equals("carlos@gmail.com"))
        );
    }
}
