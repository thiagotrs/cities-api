package one.digitalinnovation.citiesapi.cities.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.citiesapi.cities.entities.City;
import one.digitalinnovation.citiesapi.cities.services.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {
    
    private final CityService cityService;

    public CityController(final CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public Page<City> listCities(Pageable page) {
        return cityService.list(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable Long id) {
        return ResponseEntity.of(cityService.getOne(id));
    }

}
