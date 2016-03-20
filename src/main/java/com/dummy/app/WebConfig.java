package com.dummy.app;

import com.dummy.controllers.BaseController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Intel on 8/30/2015.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = BaseController.class)
public class WebConfig extends WebMvcConfigurerAdapter {
}
