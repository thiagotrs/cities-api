package one.digitalinnovation.citiesapi.cities.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import one.digitalinnovation.citiesapi.cities.entities.City;
import one.digitalinnovation.citiesapi.cities.entities.EarthRadius;
import one.digitalinnovation.citiesapi.cities.repositories.CityRepository;

@Service
public class CityService {
    
    private final CityRepository cityRepository;

    public CityService(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Page<City> list(Pageable page) {
        return cityRepository.findAll(page);
    }

    public Optional<City> getOne(Long id) {
        return cityRepository.findById(id);
    }

    public BigDecimal distanceByPointsInMiles(final Long city1, final Long city2) {
        return distanceByPoints(city1, city2, EarthRadius.MILES);
    }

    public BigDecimal distanceByPointsInMeters(final Long city1, final Long city2) {
        return distanceByPoints(city1, city2, EarthRadius.METERS);
    }

    public BigDecimal distanceByPoints(final Long city1, final Long city2, 
                                       final EarthRadius unit) {

        List<City> cities = cityRepository.findAllById(List.of(city1, city2));
        City c1 = cities.get(0);
        City c2 = cities.get(1);

        return BigDecimal.valueOf(distance(c1.getLatitude(), c2.getLatitude(), 
                                           c1.getLongitude(), c2.getLongitude(), 
                                           unit));
    }

    private double distance(BigDecimal lat1, BigDecimal lat2, BigDecimal long1, 
                            BigDecimal long2, EarthRadius unit) {

        double lg1 = Math.toRadians(long1.doubleValue());
        double lg2 = Math.toRadians(long2.doubleValue());
        double lt1 = Math.toRadians(lat1.doubleValue());
        double lt2 = Math.toRadians(lat2.doubleValue());

        // Haversine formula
        double a = Math.pow(Math.sin((lt2 - lt1) / 2), 2) 
                    + Math.cos(lt1) * Math.cos(lt2) 
                    * Math.pow(Math.sin((lg2 - lg1) / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double r = unit.getValue().doubleValue();

        return c * r;
    }

}
