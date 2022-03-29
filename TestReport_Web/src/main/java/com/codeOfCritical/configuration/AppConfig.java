package com.codeOfCritical.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@ComponentScan("com.codeOfCritical.data")
public class AppConfig {
}
