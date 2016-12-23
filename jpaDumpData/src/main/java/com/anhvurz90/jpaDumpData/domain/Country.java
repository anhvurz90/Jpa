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
public class Country {

  @Id
  @GeneratedValue
  private Long id;
  
//  ID
//  NAME
//  BBG_CODE
//  WB_CODE
//  REGION_ID
//  COUNTRY_OF_DOMICILE
//  IPO_REGION_ID  
  
  private String name;
  
  @Column(name = "BBG_CODE")
  private String bbgCode;
  @Column(name = "WB_CODE")
  private String wbCode;
  @Column(name = "REGION_ID")
  private Long regionId;
  @Column(name = "COUNTRY_OF_DOMICILE")
  private String countryOfDomicile;
  @Column(name = "IPO_REGION_ID")
  private Long ipoRegionId;
  
  public Country() {}
  
  public Country(long id) {
    this.id = id;
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
  
  public String getBbgCode() {
    return bbgCode;
  }

  public void setBbgCode(String bbgCode) {
    this.bbgCode = bbgCode;
  }

  public String getWbCode() {
    return wbCode;
  }

  public void setWbCode(String wbCode) {
    this.wbCode = wbCode;
  }

  public Long getRegionId() {
    return regionId;
  }

  public void setRegionId(Long regionId) {
    this.regionId = regionId;
  }

  public String getCountryOfDomicile() {
    return countryOfDomicile;
  }

  public void setCountryOfDomicile(String countryOfDomicile) {
    this.countryOfDomicile = countryOfDomicile;
  }

  public Long getIpoRegionId() {
    return ipoRegionId;
  }

  public void setIpoRegionId(Long ipoRegionId) {
    this.ipoRegionId = ipoRegionId;
  }

  

  @Override
  public String toString() {
    return "Country [id=" + id + ", name=" + name + ", bbgCode=" + bbgCode + ", wbCode=" + wbCode + ", regionId="
        + regionId + ", countryOfDomicile=" + countryOfDomicile + ", ipoRegionId=" + ipoRegionId + "]";
  }

  public static class Writer implements com.anhvurz90.jpaDumpData.writer.Writer<Country> {

    @Override
    public void writeToFile(String fileName, List<Country> countries) throws IOException {
      PrintWriter out = new PrintWriter(
          new BufferedWriter(
                  new FileWriter(fileName)));
      out.println("id;name;bbg_code;wb_code;region_id;country_of_domicile;ipo_region_id");
      for (Country c: countries) {
        out.println(
            String.format("%d;%s;%s;%s;%d;%s;%d",
            c.getId(), c.getName(), c.getBbgCode(),
            c.getWbCode(),c.getRegionId(),c.getCountryOfDomicile(),
            c.getIpoRegionId()));
      }
      out.close();

    }

  }
  
}
