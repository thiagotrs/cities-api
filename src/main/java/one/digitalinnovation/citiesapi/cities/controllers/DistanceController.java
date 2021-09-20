package one.digitalinnovation.citiesapi.cities.controllers;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.citiesapi.cities.entities.EarthRadius;
import one.digitalinnovation.citiesapi.cities.services.CityService;

@RestController
@RequestMapping("/distances")
public class DistanceController {
    
    private final CityService cityService;

    public DistanceController(final CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public Map<String, BigDecimal> getByMath(@RequestParam(name = "from") final Long city1, 
                                @RequestParam(name = "to") final Long city2,
                                @RequestParam final EarthRadius unit) {
        return Map.of("Distance in " + unit, cityService.distanceByPoints(city1, city2, unit));
    }

    @GetMapping("/in-miles")
    public Map<String, BigDecimal> getByPoints(@RequestParam(name = "from") final Long city1, 
                                  @RequestParam(name = "to") final Long city2) {
        return Map.of("Distance in Miles", cityService.distanceByPointsInMiles(city1, city2));
    }

    @GetMapping("/in-meters")
    public Map<String, BigDecimal> getByCube(@RequestParam(name = "from") final Long city1, 
                                @RequestParam(name = "to") final Long city2) {
        return Map.of("Distance in Meters", cityService.distanceByPointsInMeters(city1, city2));
    }

}
