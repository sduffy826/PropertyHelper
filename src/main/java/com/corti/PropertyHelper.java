package com.corti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyHelper {
  private static boolean debugIt = false;
  
  // Return an input stream for the property file name passed in; the file should be located 
  //   in the same directory as the class files... (getPath() loc), used this instead of getPath
  //   as net less code.
  public static InputStream getInputStreamForFile(String _propertyFile) {    
    return PropertyHelper.class.getClassLoader().getResourceAsStream(_propertyFile);
  }

  // Return the path where the class files exist
  public static String getPath() {
    return Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1);        
  }
  
  // Return properyt object for a given property filename
  public static Properties getPropertyObject(String _propertyFileName) {
    Properties properties = new Properties();
    
    if (debugIt) System.out.println("PropertyHelper.getPath(): " + getPath());
    // the old code used the path...i.e.
    //     String propertiesPathAndName = getPath() + _propertyFile;
    //      properties.load(new FileInputStream(propertiesPathAndName));
        
    InputStream inputStream = getInputStreamForFile(_propertyFileName);
    
    if (debugIt) System.out.println("Property file inputStream: " + ( inputStream == null  ? "isNull" : inputStream.toString()));
       
    try {
      properties.load(inputStream);
    } catch (Exception e) {
      // Nothing to do
    }
    
    return properties;    
  }
  
  public static void dumpAllProperties(Properties _propertyObject) {
    // Just outputs the values
    System.out.println("property.Values().toString(): " + _propertyObject.values().toString());
    
    // Good, shows the key and value pairs of all the elements in the property file
    System.out.println("Property.toString(): " + _propertyObject.toString());
    
    // This doesn't show anything of value, so commented out
    // System.out.println("Property.keys().toString(): " + _propertyObject.keys().toString());
    
    // Loop thru and show all the key and values individually
    Enumeration<Object> keys = _propertyObject.keys();
    while (keys.hasMoreElements()) {
      String key = (String)keys.nextElement();
      String value = (String)_propertyObject.get(key);
      System.out.println("Key is: " + key + " value is: " + value);
    }
  }
  
  // Return a map that has all the values from the properties file
  public static Map<String, String> getAllProperties(Properties _propertyObject) {
    Map<String, String> rtnMap = new HashMap<>();
    
    // Loop thru and show all the key and values individually
    Enumeration<Object> keys = _propertyObject.keys();
    while (keys.hasMoreElements()) {
      String key = (String)keys.nextElement();
      String value = (String)_propertyObject.get(key);
      rtnMap.put(key,  value);
    }
    return rtnMap;
  }
   
  // Get property, passed in property filename and name of the property
  public static String getProperty(String _propertyFile, String _propertyName) {
    return PropertyHelper.getPropertyObject(_propertyFile).getProperty(_propertyName).trim();
  }    
  
  public static void setDebugValue(boolean _debugItValue) {
    debugIt = _debugItValue;
  }
}