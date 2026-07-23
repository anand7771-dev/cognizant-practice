package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {

        testGetAllCountries();

        testFindCountryByCode();

        testAddCountry();

        testUpdateCountry();

        testDeleteCountry();
    }

    private void testGetAllCountries() {

        System.out.println("\n===== ALL COUNTRIES =====");

        countryService.getAllCountries().forEach(System.out::println);
    }

    private void testFindCountryByCode() {

        System.out.println("\n===== FIND COUNTRY =====");

        Country country = countryService.findCountryByCode("IN");

        System.out.println(country);
    }

    private void testAddCountry() {

        System.out.println("\n===== ADD COUNTRY =====");

        Country country = new Country("JP", "Japan");

        countryService.addCountry(country);

        countryService.getAllCountries().forEach(System.out::println);
    }

    private void testUpdateCountry() {

        System.out.println("\n===== UPDATE COUNTRY =====");

        countryService.updateCountry("JP", "Japan Updated");

        System.out.println(countryService.findCountryByCode("JP"));
    }

    private void testDeleteCountry() {

        System.out.println("\n===== DELETE COUNTRY =====");

        countryService.deleteCountry("JP");

        countryService.getAllCountries().forEach(System.out::println);
    }
}