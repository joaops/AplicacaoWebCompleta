/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.awc.dozer.converter;

import org.dozer.CustomConverter;

/**
 *
 * @author João
 */
public class TimeZoneConverter implements CustomConverter {

    @Override
    public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
        java.util.TimeZone source;
        java.util.TimeZone destination = null;        
        
        if (sourceClass.isInstance(java.util.TimeZone.class))
        {
            source = (java.util.TimeZone) sourceFieldValue;
            
            if (source == null) {
                return null;
            }

            if (destinationClass.isInstance(java.util.TimeZone.class))
            {
                if (existingDestinationFieldValue == null)
                {
                    destination = (java.util.TimeZone) source.clone();
                } else {
                    destination = (java.util.TimeZone) existingDestinationFieldValue;
                    destination.setID(source.getID());
                }
            }
        }
        return destination;
    }
}