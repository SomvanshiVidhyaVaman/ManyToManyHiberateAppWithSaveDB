package org.example;


import jakarta.persistence.TypedQuery;
import org.example.domain.Employees;
import org.example.domain.Projects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ManyToManyHibernateAppWithFetchDB {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        TypedQuery typedQuery=session.createQuery("from Projects projects");
        List<Projects> list=typedQuery.getResultList();
        Iterator<Projects> iterator= list.iterator();

        while (iterator.hasNext()) {
            Projects projects1 = iterator.next();
            System.out.println(projects1.getProject_Domain() + " " + projects1.getProject_Name() + " " + projects1.getProject_Version());

            Set<Employees> set1=projects1.getEmployees();
            Iterator<Employees> iterator1=set1.iterator();
            while (iterator1.hasNext()){
                Employees employees=iterator1.next();
                System.out.println(employees.getEmp_Name()+""+employees.getEmp_Address());
            }
        }
        session.close();
        System.out.println("data successfully retrive");
    }
}
