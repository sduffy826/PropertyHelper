### Common (trivial) Project
#### It contains a little helper class (PropertyHelper) to deal with property files.  
I wrote it so that I could have common code that could access property files, no matter where the code
was being called from (within eclipse, a jar file or the path).  Note: I found out about 
guava after this was written, research more on that and update this accordingly :)

It's trivial to use, here's some methods:
- static method **getPropertyObject**(String &lt;propertyFileName&gt;) will return a
    java.util.Properties object.  This is the method of most interest, once you have a properties 
    object you can call methods (i.e getProperty(&lt;propertyKeyName&gt;))  Note: the filename should
    just be that (no path).
- static method **dumpAllProperties**(java.util.Properties &lt;propertyObject&gt;) will write all the 
    properties to the console (keys/values)
- static method **getAllProperties**(java.util.Properties &lt;propObj&gt;) returns a java.util.Map 
    that has the key/value pairs (i.e. Map&lt;String,String&gt;)
- static method **getStream**(String &lt;fileName&gt;) returns an java.io.InputStream for the file 
    passed in; it's intended to open the resource within the project, intended for 'property files' but 
    should work for any resource.  Again, just pass filename, no path.
- static method **getProperty**(String &lt;propertyFileName&gt;, String &lt;propertyKeyName&gt;) returns 
    a String that represents the 'value' for the given 'key' (propertyName).  Intent is that if you 
    only care about one property you can call this method; if you want multiple it's better to deal with 
    property object directly.


Misc 
- static method **getPath**() returns the path where running class was loaded from 

To turn debugging on/off you can:
- call static method **setDebugValue**(boolean &lt;debugFlag&gt;) to set debugging on (True) or off (False).

Testing/example
- Take a look at **TestPropertyHelper** 