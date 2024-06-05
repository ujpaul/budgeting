package com.budgeting.burdgetmanagement.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class ResponseDto {

  private Date expiryDate;
  private Integer responseCode;
  private String token;
  private String username;
  private String message;

  public ResponseDto(String message, Date expiryDate, Integer responseCode, String token, String username) {
    this.message = message;
    this.expiryDate = expiryDate;
    this.responseCode = responseCode;
    this.token = token;
    this.username = username;
  }
  public ResponseDto(Integer responseCode,String message){
    this.responseCode = responseCode;
    this.message = message;

  }

  public ResponseDto(Date expiryDate, int responseCode, String token, String username){
    this.expiryDate = expiryDate;
    this.responseCode =  responseCode;
    this.token = token;
    this.username  = username;
  }
}
