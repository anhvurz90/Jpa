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
package com.anhvurz90.jpa6OTO.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anhvurz90.jpa6OTO.domain.Department3;
import com.anhvurz90.jpa6OTO.domain.Employee3;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 29, 2015  
 */
public class OneToOne {

  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
    EntityManager manager = factory.createEntityManager();
    
    manager.getTransaction().begin();
    
    //Create Department entity
    Department3 d1 = new Department3("Development");
    manager.persist(d1);
    
    //Create Employee entities
    Employee3 e1 = new Employee3("Satish", 45000.0, "Technical Writer", d1);
    
    //Store employees
    manager.persist(e1);
    
    manager.getTransaction().commit();
    manager.close();
    factory.close();
  }
}
