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
import javax.persistence.Persistence;

import javax.persistence.EntityManagerFactory;

import com.anhvurz90.jpa2.domain.Employee;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 22, 2015  
 */
public class UpdateEmployee {

  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit2");
    EntityManager manager = factory.createEntityManager();
    manager.getTransaction().begin();
    Employee e = manager.find(Employee.class, 1201);
    //before update;
    System.out.println(e);
    e.setEsalary(46000);
    manager.getTransaction().commit();
    //after update
    System.out.println(e);
    manager.close();
    factory.close();
  }
}
