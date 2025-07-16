package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class EmployeeFactory {

    public static Employee createEmployee(String employeeNumber, String firstName, String lastName) {
        if (Helper.isNullOrEmpty(employeeNumber) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)) {
            return null;
        }



        return new Employee.Builder()
                .setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }

    public static Employee createEmployee(String employeeNumber, String firstName, String lastName, String email, String identityNumber) {
        if (Helper.isNullOrEmpty(employeeNumber) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)) {
            return null;
        }
        if (!Helper.isValidEmail(email)){
            return null;
        }
        if (Helper.isNullOrEmpty(identityNumber)) {
            return null;
        }
        LocalDate dateOfBirth = Helper.getDateOfBirth(identityNumber);

        return new Employee.Builder()
                .setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setDateOfBirth(dateOfBirth)
                .setIdentityNumber(identityNumber)
                .build();
    }
}
