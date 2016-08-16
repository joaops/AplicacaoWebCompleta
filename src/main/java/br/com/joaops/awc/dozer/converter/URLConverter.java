/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.awc.dozer.converter;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

/**
 *
 * @author João
 */
public class URLConverter implements CustomConverter {
    
    @Override
    public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
        java.net.URL source;
        java.net.URL destination = null;        
        
        if (sourceClass.isInstance(java.net.URL.class))
        {
            source = (java.net.URL) sourceFieldValue;
            
            if (source == null) {
                return null;
            }

            if (destinationClass.isInstance(java.net.URL.class))
            {
                if (existingDestinationFieldValue == null)
                {
                    try {
                        destination = new java.net.URL(source.toString());
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(URLConverter.class.getName()).log(Level.SEVERE, null, ex);
                        throw new MappingException("URLConverter MalformedURLException: " + ex.getLocalizedMessage());
                    }
                } else {
                    throw new MappingException("URLConverter cannot use existing destination field value");
                }
            }
        }
        
        return destination;
    }
    
}