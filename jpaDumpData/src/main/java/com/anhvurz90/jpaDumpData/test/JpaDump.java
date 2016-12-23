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
package com.anhvurz90.jpaDumpData.test;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.anhvurz90.jpaDumpData.domain.Country;
import com.anhvurz90.jpaDumpData.domain.Region;
import com.anhvurz90.jpaDumpData.domain.Sector;
/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 21, 2015  
 */
public class JpaDump {
  
  private EntityManager manager;
  
  public JpaDump(EntityManager manager) {
    this.manager = manager;
  }
  
  public static void main(String[] args) {
    //mvn compile exec:java -Dexec.mainClass=
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
    EntityManager manager = factory.createEntityManager();
    JpaDump dump = new JpaDump(manager);
    
    EntityTransaction tx = manager.getTransaction();
    tx.begin();
    try {
      //dump.listRegions();
      //dump.listCountries();
      dump.listSectors();
    } catch (Exception e) {
      e.printStackTrace();
    }
    tx.commit();
    
    System.out.println("...done!");
  }
  
  private void listSectors() throws IOException { 
    List<Sector> sectors = manager.createQuery("Select s From Sector s", Sector.class)
                                       .getResultList();
    System.out.println("num of sectors: " + sectors.size());
    new Sector.Writer().writeToFile("Sector.csv", sectors);
  }
  
  private void listCountries() throws IOException { 
    List<Country> countries = manager.createQuery("Select c From Country c", Country.class)
                                       .getResultList();
    System.out.println("num of countries: " + countries.size());
    new Country.Writer().writeToFile("Country.csv", countries);
  }
  
  private void listRegions() throws IOException { 
    List<Region> regions = manager.createQuery("Select r From Region r", Region.class)
                                       .getResultList();
    System.out.println("num of regions: " + regions.size());
    new Region.Writer().writeToFile("Region.csv", regions);
  }
}
