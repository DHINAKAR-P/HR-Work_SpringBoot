package com.hrapp.module.bootsecurity.service; 
 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
import org.springframework.beans.BeansException; 
import org.springframework.context.ApplicationContext; 
import org.springframework.context.ApplicationContextAware; 

public class InBaseService implements ApplicationContextAware { 
 
  protected final Log logger = LogFactory.getLog(getClass()); 
  protected ApplicationContext ctx; 
 
 
 
  @Override 
  public void setApplicationContext(ApplicationContext arg0) 
      throws BeansException { 
    // TODO Auto-generated method stub 
 
  } }