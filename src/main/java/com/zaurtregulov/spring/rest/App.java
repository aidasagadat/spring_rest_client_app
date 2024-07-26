package com.zaurtregulov.spring.rest;


import com.zaurtregulov.spring.rest.configuration.TheConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args ){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TheConfiguration.class);

        Communication communication = context.getBean("communication", Communication.class);



    }
}
