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
package com.anhvurz90.jpa5OTM.test;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.anhvurz90.jpa5OTM.domain.Department2;
import com.anhvurz90.jpa5OTM.domain.Employee2;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 29, 2015  
 */
public class OneToMany {

  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
    EntityManager manager = factory.createEntityManager();
    
    manager.getTransaction().begin();
    //Create Employee entities
    Employee2 e1 = new Employee2("Satish", 45000.0, "Technical Writer");
    Employee2 e2 = new Employee2("Krishna", 45000.0, "Technical Writer");
    Employee2 e3 = new Employee2("Masthanvali", 50000, "Technical Writer");
    
    //Store employees
    manager.persist(e1);
    manager.persist(e2);
    manager.persist(e3);
    
    //Create employee list
    List<Employee2> empList = new ArrayList<Employee2>();
    empList.add(e1);
    empList.add(e2);
    empList.add(e3);
    
    //Create Department entity
    Department2 d1 = new Department2("Development",  empList);
    
    //Store department
    manager.persist(d1);
    
    manager.getTransaction().commit();
    manager.close();
    factory.close();
  }
}
