package one.digitalinnovation.citiesapi.countries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.citiesapi.countries.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
    
}
