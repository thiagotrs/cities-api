package one.digitalinnovation.citiesapi.countries.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import one.digitalinnovation.citiesapi.countries.entities.Country;
import one.digitalinnovation.citiesapi.countries.repositories.CountryRepository;

@Service
public class CountryService {
    
    private final CountryRepository countryRepository;

    public CountryService(final CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Page<Country> list(Pageable page) {
        return countryRepository.findAll(page);
    }

    public Optional<Country> getOne(Long id) {
        return countryRepository.findById(id);
    }
}
