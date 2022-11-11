package br.com.sprint3.states.api.controller;

import br.com.sprint3.states.api.model.dto.StateDTO;
import br.com.sprint3.states.api.model.form.StateAtualizacaoForm;
import br.com.sprint3.states.api.model.form.StateForm;
import br.com.sprint3.states.domain.model.Regiao;
import br.com.sprint3.states.domain.model.State;
import br.com.sprint3.states.domain.repository.StateRepository;
import br.com.sprint3.states.domain.service.CadastroStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CadastroStateService cadastroStateService;

    //Ordenacao, maior população ou area
    @GetMapping
    public Page<StateDTO> listarStates(@RequestParam(required = false) Regiao regiao, Pageable pageable){
        if(regiao == null){
            Page<State> states = stateRepository.findAll(pageable);
            return StateDTO.converter(states);
        }else{
            Page<State> states = stateRepository.findByRegiao(regiao, pageable);
            return StateDTO.converter(states);
        }
    }

    @GetMapping("/{stateId}")
    public ResponseEntity<StateDTO> buscar(@PathVariable Long stateId) {

        Optional<State> state = cadastroStateService.buscarOuFalhar(stateId);

        if(state.isPresent()){
            return ResponseEntity.ok(new StateDTO(state.get()));
        }
        return ResponseEntity.notFound().build();
    }

    //Se já existir uma capital, ele dará uma exception
    @PostMapping
    @Transactional
    public ResponseEntity<StateDTO> adicionar(@RequestBody @Valid StateForm stateForm, UriComponentsBuilder uriBuilder) {
        State state = stateForm.converterForm();

        if (cadastroStateService.buscarCapital(state.getCapital()) == null) {
            cadastroStateService.adicionar(state);
            URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(state.getId()).toUri();
            return ResponseEntity.created(uri).body(new StateDTO(state));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{stateId}")
    @Transactional
    public ResponseEntity<StateDTO> atualizar(@PathVariable Long stateId,
                              @RequestBody @Valid StateAtualizacaoForm form) {

        Optional<State> stateAtual  = cadastroStateService.buscarOuFalhar(stateId);

        if(stateAtual.isPresent()){
            State state = form.atualizar(stateAtual.get());
            return ResponseEntity.ok(new StateDTO(state));
        }
       return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{stateId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long stateId) {
        Optional<State> state = cadastroStateService.buscarOuFalhar(stateId);
        if(state.isPresent()){
            cadastroStateService.excluir(stateId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
