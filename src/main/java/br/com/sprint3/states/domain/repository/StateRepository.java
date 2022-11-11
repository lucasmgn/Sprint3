package br.com.sprint3.states.domain.repository;

import br.com.sprint3.states.domain.model.Regiao;
import br.com.sprint3.states.domain.model.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    State findByCapital(String capital);
    Page<State> findByRegiao(Regiao nomeRegiao, Pageable pageable);

}
