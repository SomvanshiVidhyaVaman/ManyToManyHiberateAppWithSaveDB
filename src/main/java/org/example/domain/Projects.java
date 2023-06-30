package org.example.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int project_Id;
    private String project_Name;
    private String project_Domain;
    private String project_Version;
    @ManyToMany(mappedBy = "projects")
    Set<Employees> employees=new HashSet<Employees>();

    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }

    public int getProject_Id() {
        return project_Id;
    }

    public void setProject_Id(int project_Id) {
        this.project_Id = project_Id;
    }

    public String getProject_Name() {
        return project_Name;
    }

    public void setProject_Name(String project_Name) {
        this.project_Name = project_Name;
    }

    public String getProject_Domain() {
        return project_Domain;
    }

    public void setProject_Domain(String project_Domain) {
        this.project_Domain = project_Domain;
    }

    public String getProject_Version() {
        return project_Version;
    }

    public void setProject_Version(String project_Version) {
        this.project_Version = project_Version;
    }
}
