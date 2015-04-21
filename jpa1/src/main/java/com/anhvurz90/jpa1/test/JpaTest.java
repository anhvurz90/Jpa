/*
 * Copyright (C) 2003-2015 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.anhvurz90.jpa1.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.anhvurz90.jpa1.domain.Employee;
import com.anhvurz90.jpa1.domain.Department;
/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 21, 2015  
 */
public class JpaTest {
  
  private EntityManager manager;
  
  public JpaTest(EntityManager manager) {
    this.manager = manager;
  }
  
  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
    EntityManager manager = factory.createEntityManager();
    JpaTest test = new JpaTest(manager);
    
    EntityTransaction tx = manager.getTransaction();
    tx.begin();
    try {
      test.createEmployees();
    } catch (Exception e) {
      e.printStackTrace();
    }
    tx.commit();
    
    test.listEmployees();
    
    System.out.println("...done!");
  }
  
  private void createEmployees() {
    int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class)
                                .getResultList().size();
    if (numOfEmployees == 0) {
      Department department = new Department("java");
      manager.persist(department);
      
      manager.persist(new Employee("Jakab Gipsz", department));
      manager.persist(new Employee("Captain Nemo", department));
    }
  }
  
  private void listEmployees() { 
    List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class)
                                       .getResultList();
    System.out.println("num of employees: " + resultList.size());
    
    for (Employee e : resultList) {
      System.out.println("next employee: " + e);
    }
  }
}
