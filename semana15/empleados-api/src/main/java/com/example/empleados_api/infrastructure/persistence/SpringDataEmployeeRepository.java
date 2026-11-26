package com.example.empleados_api.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEmployeeRepository
        extends JpaRepository<EmployeeJpaEntity, Long> {
}
