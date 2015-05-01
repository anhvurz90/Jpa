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
package com.anhvurz90.jpa8Criteria.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.anhvurz90.jpa8Criteria.domain.Employee;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 29, 2015  
 */
public class CriteriaAPI {

  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
    EntityManager manager = factory.createEntityManager();
    
    CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
    CriteriaQuery<Object> query = criteriaBuilder.createQuery();
    Root<Employee> from = query.from(Employee.class);
    
    //select all records
    System.out.println("Select all records");
    CriteriaQuery<Object> select = query.select(from);
    TypedQuery<Object> typedQuery = manager.createQuery(select);
    List<Object> result = typedQuery.getResultList();
    for (Object o : result) {
      System.out.println(o);
    }
    
    //ordering the records
    System.out.println("Select all records by following ordering:");
    CriteriaQuery<Object> select1 = query.select(from);
    select1.orderBy(criteriaBuilder.asc(from.get("name")));
    TypedQuery<Object> typedQuery1 = manager.createQuery(select1);
    for (Object o : typedQuery1.getResultList()) {
      System.out.println(o);
    }
    
    manager.close();
    factory.close();
  }
}
