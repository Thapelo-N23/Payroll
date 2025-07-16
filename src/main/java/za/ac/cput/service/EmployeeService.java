package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee create(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Employee read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Employee update(Employee employee) {
        return this.repository.save(employee);
    }
    @Override
    public List<Employee> getall() {
        return this.repository.findAll();
    }
}
