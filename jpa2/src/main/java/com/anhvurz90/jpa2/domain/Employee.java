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
package com.anhvurz90.jpa2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 21, 2015  
 */
@Entity
@Table
@NamedQuery(
  query = "Select e from Employee e where e.eid= :id",
  name  = "find employee by id")
public class Employee {

  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
  private int eid;
  private String ename;
  private double esalary;
  private String edeg;
  
  public Employee() {}
  
  public Employee(int id, String name, double salary, String deg) {
    eid = id;
    ename = name;
    esalary = salary;
    edeg = deg;
  }
  
  
  public int getEid() {
    return eid;
  }

  public void setEid(int eid) {
    this.eid = eid;
  }

  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public double getEsalary() {
    return esalary;
  }

  public void setEsalary(double esalary) {
    this.esalary = esalary;
  }

  public String getEdeg() {
    return edeg;
  }

  public void setEdeg(String edeg) {
    this.edeg = edeg;
  }

  @Override
  public String toString() {
    return "Employee [id=" + eid + ", name=" + ename + 
           ", salary=" + esalary + ", deg=" + edeg + "]";
  }
  
}
