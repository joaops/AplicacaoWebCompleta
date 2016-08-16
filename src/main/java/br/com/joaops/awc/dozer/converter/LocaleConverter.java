/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.awc.dozer.converter;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

/**
 *
 * @author João
 */
public class LocaleConverter implements CustomConverter {
    
    @Override
    public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
        java.util.Locale source;
        java.util.Locale destination = null;        
        
        if (sourceClass.isInstance(java.util.Locale.class))
        {
            source = (java.util.Locale) sourceFieldValue;
            
            if (source == null) {
                return null;
            }

            if (destinationClass.isInstance(java.util.Locale.class))
            {
                if (existingDestinationFieldValue == null)
                {
                    destination = (java.util.Locale) source.clone();
                } else {
                    throw new MappingException("LocaleConverter cannot use existing destination field value");
                }
            }
        }
        
        return destination;
    }
    
}