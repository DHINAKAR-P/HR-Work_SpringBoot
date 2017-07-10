package com.hrapp.serviceimpl;

public class InBaseAuthority  { 
 
   
  public static int  ROLE_ADMIN = 100; 
  public static int ROLE_QUEUE_ADMIN = 90; 
  public static int  ROLE_CUSTOMER = 2; 
  public static int  ROLE_ASSOCIATIVE = 1; 
 
 
  public int getRoleHierArchyPosition(String role_string) { 
 
    if(role_string.equals("ROLE_ADMIN")) { 
      return InBaseAuthority.ROLE_ADMIN; 
    }else if(role_string.equals("ROLE_QUEUE_ADMIN")) { 
      return InBaseAuthority.ROLE_QUEUE_ADMIN; 
    }else if(role_string.equals("ROLE_CUSTOMER")) { 
      return InBaseAuthority.ROLE_CUSTOMER; 
    }else if(role_string.equals("ROLE_ASSOCIATIVE")){ 
      return InBaseAuthority.ROLE_ASSOCIATIVE; 
    } else { 
      return 0; 
    } 
  } 
 
 
}