package br.com.sprint3.states.domain.service;

import br.com.sprint3.states.domain.model.State;
import br.com.sprint3.states.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CadastroStateService {

    @Autowired
    private StateRepository stateRepository;

    @Transactional
    public State adicionar(State state) {
        return stateRepository.save(state);
    }

    //Verifica a existencia e tras do bd, elemina o optional, tirando serviço do controller
    public Optional<State> buscarOuFalhar(Long stateId) {
        return stateRepository.findById(stateId);
    }

    public State buscarCapital(String capital) {
        return stateRepository.findByCapital(capital);
    }

    @Transactional
    public void excluir(Long stateId) {
        stateRepository.deleteById(stateId);
        stateRepository.flush();
    }
}
