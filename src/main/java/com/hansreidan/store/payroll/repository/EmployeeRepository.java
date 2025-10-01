package com.hansreidan.store.payroll.repository;

import com.hansreidan.store.payroll.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
