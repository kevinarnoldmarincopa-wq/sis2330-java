package com.example.empleados_api.infrastructure.persistence;

import com.example.empleados_api.domain.entity.Employee;
import com.example.empleados_api.domain.entity.Salary;
import com.example.empleados_api.domain.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final SpringDataEmployeeRepository jpaRepository;

    public EmployeeRepositoryImpl(SpringDataEmployeeRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeJpaEntity entity = new EmployeeJpaEntity(
            employee.getId(),
            employee.getName(),
            employee.getEmail(),
            employee.getSalary().getAmount(),
            employee.getSalary().getCurrency()
        );

        EmployeeJpaEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Employee> findAll() {
        return jpaRepository.findAll()
            .stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private Employee toDomain(EmployeeJpaEntity entity) {
        return new Employee(
            entity.getId(),
            entity.getName(),
            entity.getEmail(),
            new Salary(entity.getSalary(), entity.getCurrency())
        );
    }
}
