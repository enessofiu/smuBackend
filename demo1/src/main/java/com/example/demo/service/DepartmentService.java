package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void removeDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department updateDepartment(Long id, Department newDepartmentData) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            Department existingDepartment = optionalDepartment.get();
            existingDepartment.setName(newDepartmentData.getName());
            existingDepartment.setOfficeNumber(newDepartmentData.getOfficeNumber());
            existingDepartment.setEmail(newDepartmentData.getEmail());
            existingDepartment.setConsultationHour(newDepartmentData.getConsultationHour());
            return departmentRepository.save(existingDepartment);
        } else {
            throw new RuntimeException("Department not found with id: " + id);
        }
    }

    public Department getDepartmentById(Long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        return optionalDepartment.orElse(null); // Return department if present, otherwise null
    }
}
