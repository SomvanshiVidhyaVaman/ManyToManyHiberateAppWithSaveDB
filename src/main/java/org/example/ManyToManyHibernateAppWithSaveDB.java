package org.example;

import org.example.domain.Employees;
import org.example.domain.Projects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Set;

public class ManyToManyHibernateAppWithSaveDB {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Employees employees=new Employees();
        employees.setEmp_Name("Krishna Shinde");
        employees.setEmp_Address("Pune");

        Projects projects=new Projects();
        projects.setProject_Name("IOT");
        projects.setProject_Domain("Internet Provider");
        projects.setProject_Version("3.0");


        projects.getEmployees().add(employees);
        employees.getProjects().add(projects);

        session.persist(employees);
        transaction.commit();
        session.close();

        System.out.println("Data has been succesfully saved in db");
    }
}