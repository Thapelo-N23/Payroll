package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeControllerTest {
private static Employee employee;

@Autowired
private TestRestTemplate restTemplate;

private static final String BASE_URL = "http://localhost:8080/payroll/employee";
@BeforeAll
public static void setUp() {
employee = EmployeeFactory.createEmployee("22234", "Moanakoena", "Ngwenya", "thapelongwenya700@gmail.com", "0209225091088");
}
    @Test
    void a_create() {
    String url = BASE_URL + "/create";
    ResponseEntity<Employee> postResponse = this.restTemplate.postForEntity(url, employee, Employee.class);
    assertNotNull(postResponse);
    Employee employeeSaved = postResponse.getBody();
    assertEquals(employee.getEmployeeNumber(), employeeSaved.getEmployeeNumber());
        System.out.println("Created Employee " + employeeSaved);
    }

    @Test
    void b_read() {
    String url = BASE_URL + "/read" + employee.getEmployeeNumber();
    ResponseEntity<Employee> postResponse = this.restTemplate.getForEntity(url, Employee.class);
    assertEquals(employee.getEmployeeNumber(), postResponse.getBody().getEmployeeNumber());
    System.out.println("Read Employee " + postResponse.getBody());
    }

    @Test
    void c_update() {
        LocalDate dateOfBirth = LocalDate.of(2002, 12, 6);
    Employee updatedEmployee = new Employee.Builder().copy(employee)
            .setEmail("koketso@gmail.com")
            .setDateOfBirth(dateOfBirth)
            .build();
    String url = BASE_URL + "/update";
     this.restTemplate.put(url, updatedEmployee);

     ResponseEntity<Employee> postResponse = this.restTemplate.getForEntity(BASE_URL + "/read/" + updatedEmployee.getEmployeeNumber(), Employee.class);

     assertEquals((postResponse.getStatusCode()), HttpStatus.OK);
    assertNotNull(postResponse.getBody());
   // assertEquals(updatedEmployee.getFirstName(), postResponse.getBody().getFirstName());
    System.out.println("Updated Employee " + postResponse.getBody());
    }

    @Test
    void e_getall() {
    String url = BASE_URL + "/getall";
    ResponseEntity<Employee[]> postResponse = this.restTemplate.getForEntity(url, Employee[].class);
    assertNotNull(postResponse.getBody());
   // assertTrue(postResponse.getBody().length > 0);
        System.out.println("Get All Employee " + postResponse.getBody());
    }
}