package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringLearnApplication.class, args);

        displayDate();

        displayCountry();

        displayCountries();
    }

    public static void displayDate() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("date-format.xml");

        SimpleDateFormat format =
                context.getBean("dateFormat", SimpleDateFormat.class);

        try {

            Date date = format.parse("31/12/2018");

            LOGGER.debug("Date : {}", date);

        } catch (Exception e) {

            LOGGER.error("Exception while parsing date", e);

        }

        LOGGER.info("END");
    }

    public static void displayCountry() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country1 =
                context.getBean("in", Country.class);

        Country country2 =
                context.getBean("in", Country.class);

        LOGGER.debug("Country 1 : {}", country1);

        LOGGER.debug("Country 2 : {}", country2);

        LOGGER.info("END");
    }

    @SuppressWarnings("unchecked")
    public static void displayCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countryList =
                (List<Country>) context.getBean("countryList");

        LOGGER.debug("Countries : {}", countryList);

        LOGGER.info("END");
    }
}