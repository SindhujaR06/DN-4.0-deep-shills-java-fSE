
package com.cognizant.springlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Map<String, String>> getCountries() {
        List<Map<String, String>> countries = new ArrayList<>();
        countries.add(Map.of("code", "US", "name", "United States"));
        countries.add(Map.of("code", "DE", "name", "Germany"));
        countries.add(Map.of("code", "IN", "name", "India"));
        countries.add(Map.of("code", "JP", "name", "Japan"));
        return countries;
    }
}
