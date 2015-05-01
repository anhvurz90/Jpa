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
package com.anhvurz90.jpa7MTM.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anhvurz90.jpa7MTM.domain.Clas;
import com.anhvurz90.jpa7MTM.domain.Teacher;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 29, 2015  
 */
public class ManyToMany {

  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
    EntityManager manager = factory.createEntityManager();
    
    manager.getTransaction().begin();
    
    //Create Clas Entity
    Clas class1 = new Clas("1st", null);
    Clas class2 = new Clas("2nd", null);
    Clas class3 = new Clas("3rd", null);
    
    //Store classes;
    manager.persist(class1);
    manager.persist(class2);
    manager.persist(class3);
    
    //Create class sets
    Set<Clas> classSet1 = new HashSet<Clas>(Arrays.asList(new Clas[] {class1, class2, class3}));
    Set<Clas> classSet2 = new HashSet<Clas>(Arrays.asList(new Clas[] {class3, class1, class2}));
    Set<Clas> classSet3 = new HashSet<Clas>(Arrays.asList(new Clas[] {class2, class3, class1}));
    
    //Create Teacher entities
    Teacher t1 = new Teacher("Satish", "Java", classSet1);
    Teacher t2 = new Teacher("Krishna", "Adv Java", classSet2);
    Teacher t3 = new Teacher("Masthanvali", "DB2", classSet3);
    
    //Store teachers
    manager.persist(t1);
    manager.persist(t2);
    manager.persist(t3);
    
    manager.getTransaction().commit();
    manager.close();
    factory.close();
  }
}
