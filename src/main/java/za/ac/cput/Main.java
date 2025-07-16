package za.ac.cput.domain;

import za.ac.cput.factory.EmployeeFactory;

public class Main {
    public static void main(String[] args) {
  Employee e1 = EmployeeFactory.createEmployee("12345", "Tumelo", "Ngwenya");
   System.out.println(e1.toString());
    }
}
