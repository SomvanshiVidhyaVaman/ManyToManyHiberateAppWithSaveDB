package org.example.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
//This is my First ManyToMany mapping relationship application
@Entity
@Table(name = "employee")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emp_Id;
    private String emp_Name;
    private String emp_Address;
    @ManyToMany(targetEntity = Projects.class,cascade = CascadeType.ALL)
    @JoinTable(name = "employee_projects",joinColumns ={@JoinColumn(name="emp_Id")},
            inverseJoinColumns = {@JoinColumn(name = "project_Id")})
    Set<Projects> projects=new HashSet<Projects>();

    public int getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(int emp_Id) {
        this.emp_Id = emp_Id;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public String getEmp_Address() {
        return emp_Address;
    }

    public void setEmp_Address(String emp_Address) {
        this.emp_Address = emp_Address;
    }

    public Set<Projects> getProjects() {
        return projects;
    }

    public void setProjects(Set<Projects> projects) {
        this.projects = projects;
    }
}
