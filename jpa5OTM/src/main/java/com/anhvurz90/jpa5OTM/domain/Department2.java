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
package com.anhvurz90.jpa5OTM.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 29, 2015  
 */
@Entity
public class Department2 {
  
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private int id;
  private String name;
  
  @OneToMany(targetEntity = Employee2.class)
  private List<Employee2> employeeList;
  
  public Department2() { }

  public Department2(String name, List<Employee2> employeeList) {
    super();
    this.name = name;
    this.employeeList = employeeList;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Employee2> getEmployeeList() {
    return employeeList;
  }

  public void setEmployeeList(List<Employee2> employeeList) {
    this.employeeList = employeeList;
  }
  
  
  
}