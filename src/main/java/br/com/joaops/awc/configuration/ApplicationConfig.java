/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.awc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author João
 */
@Configuration
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages={"br.com.joaops.awc"}, 
        excludeFilters=@ComponentScan.Filter(
                type=FilterType.REGEX, 
                pattern={"br.com.joaops.awc.controller.*",
                         "br.com.joaops.awc.model.*"}))
public class ApplicationConfig {
    
}