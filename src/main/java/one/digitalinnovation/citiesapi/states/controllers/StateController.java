package one.digitalinnovation.citiesapi.states.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.citiesapi.states.entities.State;
import one.digitalinnovation.citiesapi.states.services.StateService;

@RestController
@RequestMapping("/states")
public class StateController {
    
    private final StateService stateService;

    public StateController(final StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public List<State> listStates() {
        return stateService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getState(@PathVariable Long id) {
        return ResponseEntity.of(stateService.getOne(id));
    }

}
