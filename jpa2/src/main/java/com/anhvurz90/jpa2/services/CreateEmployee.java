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
package com.anhvurz90.jpa2.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anhvurz90.jpa2.domain.Employee;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 22, 2015  
 */
public class CreateEmployee {
  
  public static void main(String[] args) {
    EntityManagerFactory emFactory = 
        Persistence.createEntityManagerFactory("persistenceUnit2");
    EntityManager eManager = emFactory.createEntityManager();
    try {
      eManager.getTransaction().begin();
      Employee e = new Employee(1201, "Gopal", 4000, "Technical Manager");
      Employee e2 = new Employee(1202, "Manisha", 4200, "Proof reader");
      eManager.persist(e);
      eManager.persist(e2);
      eManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    eManager.close();
    emFactory.close();
  }

}

