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
package com.anhvurz90.jpa3.services.joinedtable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anhvurz90.jpa3.domain.joinedtable.NonTeachingStaff2;
import com.anhvurz90.jpa3.domain.joinedtable.TeachingStaff2;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 28, 2015  
 */
public class SaveClient {
  
  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit3");
    EntityManager manager = factory.createEntityManager();
    
    manager.getTransaction().begin();
    
    //Teaching staff entities
    TeachingStaff2 ts1 = new TeachingStaff2(1, "Gopal", "MSc MEd", "Maths");
    TeachingStaff2 ts2 = new TeachingStaff2(2, "Manisha", "BSc BEd", "English");
    
    //Nonteaching staff entities
    NonTeachingStaff2 nts1 = new NonTeachingStaff2(3, "Satish", "Accounts");
    NonTeachingStaff2 nts2 = new NonTeachingStaff2(4, "Krishna", "Office Admin");
    
    //storing all entities
    manager.persist(ts1);
    manager.persist(ts2);
    manager.persist(nts1);
    manager.persist(nts2);
    
    manager.getTransaction().commit();
    
    manager.close();
    factory.close();
  }

}
