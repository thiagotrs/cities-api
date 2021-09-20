package one.digitalinnovation.citiesapi.cities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.citiesapi.cities.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {

}