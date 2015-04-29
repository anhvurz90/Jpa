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
package com.anhvurz90.jpa3.services.tableperclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.anhvurz90.jpa3.domain.tableperclass.TeachingStaff3;
import com.anhvurz90.jpa3.domain.tableperclass.NonTeachingStaff3;
/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 29, 2015  
 */
public class SaveClient {

  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit3");
    EntityManager manager = factory.createEntityManager();
    
    manager.getTransaction().begin();
    
    //Teaching staff entity
    TeachingStaff3 ts1 = new TeachingStaff3(1, "Gopal", 
                                  "MSc MEd", "Maths");
    TeachingStaff3 ts2 = new TeachingStaff3(2, "Manisha",
                                  "BSc BEd", "English");
    
    //Non-teaching staff entity
    NonTeachingStaff3 nts1 = new NonTeachingStaff3(3, "Satish", 
                                  "Accounts");
    NonTeachingStaff3 nts2 = new NonTeachingStaff3(4, "Krishna",
                                  "Office Admin");
    
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
