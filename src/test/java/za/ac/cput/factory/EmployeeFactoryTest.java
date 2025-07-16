package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


class EmployeeFactoryTest {
    private static Employee e1 = EmployeeFactory.createEmployee("12344", "Esihle", "Diko");
    private static Employee e2 = EmployeeFactory.createEmployee("22223", "Thapelo", "Ngwenya", "thapelo_n@icloud.com", "0209225091088");
    private static Employee e3 = EmployeeFactory.createEmployee("21217", "Nkhonthe", "Ngwenya", "nkhonthengwenya89gmail.com", "0503278570292");

    @Test
    @Order(1)
    public void testCreateEmployee() {
    assertNotNull(e1);
        System.out.println(e1.toString());
    }

@Test
@Order(2)
    public void testCreateEmployeeWithAllAttributes() {
assertNotNull(e2);
System.out.println(e2.toString());
    }

@Test
@Order(3)
    public void testCreateEmployeeThatFails(){
    assertNotNull(e3);
    System.out.println(e3.toString());
    }

    @Test
    @Order(4)
    @Disabled
    public void testNotImplementedYet(){

    }

}