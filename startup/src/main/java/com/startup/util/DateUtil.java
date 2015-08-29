package com.startup.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String getDateString(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static String getDateString2(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
 	
	public static Date getDefaultDate(String dateStr) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		}
	    catch (Exception e) {
	        return null;
	    }
	}
	
	public static String getDateStringMM(Date date) {
		return new SimpleDateFormat("MM").format(date);
	}
	
	public static String getDateStringdd(Date date) {
		return new SimpleDateFormat("dd").format(date);
	}
	
	public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
       return Integer.parseInt(String.valueOf(between_days));           
    }    

    public static int daysBetween(String smdate,String bdate) throws ParseException{  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
       return Integer.parseInt(String.valueOf(between_days));     
    } 
}
