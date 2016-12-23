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
package com.anhvurz90.jpaDumpData.domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sector {

  @Id
  @GeneratedValue
  private Long id;
  
  private String name;
  
  private String description;
  
  private String type;
  
  @Column(name = "parent_id")
  private Long parentId;
  
  public Sector() {}
  
  public Sector(long id, String name, String type) {
    this.id = id;
    this.name = name;
    this.type = type;
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
  
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  @Override
  public String toString() {
    return "Region [id=" + id + ", name=" + name + ", type=" + type + "]";
  }
  
  public static class Writer implements com.anhvurz90.jpaDumpData.writer.Writer<Sector> {

    @Override
    public void writeToFile(String fileName, List<Sector> sectors) throws IOException {
      PrintWriter out = new PrintWriter(
          new BufferedWriter(
                  new FileWriter(fileName)));
      out.println("id;name;description;type;parent_id");
      for (Sector s: sectors) {
        out.println(
            String.format("%d;%s;%s;%s;%d",
            s.getId(), s.getName(), s.getDescription(),
            s.getType(), s.getParentId()));
      }
      out.close();

    }

  }
  
}
