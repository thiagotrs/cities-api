package one.digitalinnovation.citiesapi.countries.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.citiesapi.countries.entities.Country;
import one.digitalinnovation.citiesapi.countries.services.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(final CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public Page<Country> listCountries(Pageable page) {
        return countryService.list(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable Long id) {
        return ResponseEntity.of(countryService.getOne(id));
    }
}
