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
package com.anhvurz90.jpa4MTO.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anhvurz90.jpa4MTO.domain.Department;
import com.anhvurz90.jpa4MTO.domain.Employee;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 29, 2015  
 */
public class ManyToOne {

  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
    EntityManager manager = factory.createEntityManager();
    
    manager.getTransaction().begin();

    //Create Department Entity
    Department department = new Department("Development");
    manager.persist(department);
    
    //Create Employee entities
    Employee e1 = new Employee("Satish", 45000, "Technical Writer", department);
    Employee e2 = new Employee("Krishna", 45000, "Techincal Writer", department);
    Employee e3 = new Employee("Masthanvali", 50000, "Technical Writer", department);
    
    //Store employees
    manager.persist(e1);
    manager.persist(e2);
    manager.persist(e3);
    
    manager.getTransaction().commit();
    manager.close();
    factory.close();
    
  }
}
