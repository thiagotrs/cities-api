package one.digitalinnovation.citiesapi.states.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.citiesapi.states.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {
    
}
