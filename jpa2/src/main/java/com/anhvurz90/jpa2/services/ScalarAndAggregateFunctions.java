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

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 22, 2015  
 */
public class ScalarAndAggregateFunctions {
  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit2");
    EntityManager manager = factory.createEntityManager();
    //Scalar function
    Query query = manager.createQuery("Select UPPER(e.ename) from Employee e");
    List<String> list = query.getResultList();
    
    for (String e : list) {
      System.out.println("Employee Name: " + e);
    }
    
    //Aggregate function
    query = manager.createQuery("Select MAX(e.esalary) from Employee e");
    Double result = (Double)query.getSingleResult();
    
    System.out.println("Max Employee Salary: " + result);
  }
}
