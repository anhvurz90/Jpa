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
package com.anhvurz90.jpa3.domain.joinedtable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 28, 2015  
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class TeachingStaff2 extends Staff2 {

  private static final long serialVersionUID = -6894748371098267749L;
  private String qualification;
  private String subjectexpertise;
  
  public TeachingStaff2() { super(); }
  public TeachingStaff2(int id, String name,
                       String qualification, String subjectexpertise) {
    super(id, name);
    this.qualification = qualification;
    this.subjectexpertise = subjectexpertise;
  }
  public String getQualification() {
    return qualification;
  }
  public void setQualification(String qualification) {
    this.qualification = qualification;
  }
  public String getSubjectexpertise() {
    return subjectexpertise;
  }
  public void setSubjectexpertise(String subjectexpertise) {
    this.subjectexpertise = subjectexpertise;
  }
  
  
}
