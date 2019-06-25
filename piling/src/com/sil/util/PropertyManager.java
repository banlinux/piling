

package com.sil.util;

import org.springframework.core.io.Resource ;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Properties;


public class PropertyManager
{
    private static Properties p ;
    
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog (getClass ());
    
    /** Creates a new instance of PropertyManager */
    public PropertyManager ()
    {
        PropertyManager.p = new Properties () ;
    }
    
    public static String getProperty (String key)
    {
        return (PropertyManager.p.getProperty (key)) ;
    }
    
    public void setLocations (Resource [] locations)
    {
        try
        {
            for (int i = 0; i < locations.length; i++)
            {
//                logger.info ("%%%%%%%%%%%%%%%%%%%%%%%%%" + i + ". " + locations[i].getFile ().getAbsolutePath ()) ;
                
                PropertyManager.p.load (locations[i].getInputStream ()) ;
                
                locations[i].getInputStream ().close () ;
            }
        }
        catch (IOException e)
        {
            logger.info (e.getMessage ()) ;
        }
    }
}

