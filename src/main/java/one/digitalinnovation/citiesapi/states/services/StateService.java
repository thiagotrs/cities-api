package one.digitalinnovation.citiesapi.states.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import one.digitalinnovation.citiesapi.states.entities.State;
import one.digitalinnovation.citiesapi.states.repositories.StateRepository;

@Service
public class StateService {
    
    private final StateRepository stateRepository;

    public StateService(final StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<State> list() {
        return stateRepository.findAll();
    }

    public Optional<State> getOne(Long id) {
        return stateRepository.findById(id);
    }

}
