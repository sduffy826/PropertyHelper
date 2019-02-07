import java.util.Properties;

import com.corti.PropertyHelper;

public class TestPropertyHelper {

  public static void main(String[] args) {
    String propertyFile = "sample.properties";

    // If first argument is supplied then use it as the property file name
    if (args.length > 0) propertyFile = args[0];
        
    PropertyHelper.setDebugValue(true);
    Properties properties = PropertyHelper.getPropertyObject(propertyFile);
    PropertyHelper.dumpAllProperties(properties);
  }

}
