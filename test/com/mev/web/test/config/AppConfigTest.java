package com.mev.web.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 
@Configuration
@ComponentScan(basePackages = {"com.sgcom.web"}, 
excludeFilters = {@Filter(type = FilterType.ANNOTATION,value={EnableWebMvc.class,Controller.class})})
public class AppConfigTest {

}