package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeServiceTest {
    @Autowired
    private EmployeeService service;

    private Employee employee = EmployeeFactory.createEmployee("22234", "Monanakoena", "Mpae", "thapelo_n@icloud.com", "0209225091088");

    @Test
    @Order(1)
    void a_create() {
        Employee created = service.create(employee);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void b_read() {
        Employee read = service.read(employee.getEmployeeNumber());
        assertNotNull(read);
        System.out.println(read);
    }
@Order(3)
    @Test
    void d_update() {
        Employee newEmployee = new Employee.Builder().copy(employee).setFirstName("Tumelo").build();
        Employee updated = service.update(newEmployee);
        assertNotNull(updated);
        System.out.println(updated);
    }


@Order(4)
    @Test
    void e_getall() {
        System.out.println(service.getall());
    }
}