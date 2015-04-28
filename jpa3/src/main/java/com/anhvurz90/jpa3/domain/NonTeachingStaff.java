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
package com.anhvurz90.jpa3.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 26, 2015  
 */
@Entity
@DiscriminatorValue( value = "NS")
public class NonTeachingStaff extends Staff {

  private static final long serialVersionUID = -7262302090053529287L;
  
  private String areaexpertise;
  
  public NonTeachingStaff() { super(); }
  
  public NonTeachingStaff(int sid, String sname, String areaexpertise) {
    super(sid, sname);
    this.areaexpertise = areaexpertise;
  }

  public String getAreaexpertise() {
    return areaexpertise;
  }

  public void setAreaexpertise(String areaexpertise) {
    this.areaexpertise = areaexpertise;
  }
  
}
