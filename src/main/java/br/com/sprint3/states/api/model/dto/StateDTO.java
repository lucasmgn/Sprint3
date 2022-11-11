package br.com.sprint3.states.api.model.dto;

import br.com.sprint3.states.domain.model.Regiao;
import br.com.sprint3.states.domain.model.State;
import org.springframework.data.domain.Page;

public class StateDTO {

    private Long id;

    private String nome;

    private Regiao regiao;

    private Long populacao;

    private String capital;

    private Long area;

    public StateDTO(State state){
        this.id = state.getId();
        this.nome = state.getNome();
        this.regiao = state.getRegiao();
        this.populacao = state.getPopulacao();
        this.capital = state.getCapital();
        this.area = state.getArea();
    }

    public static Page<StateDTO> converter(Page<State> states) {
        return states.map(StateDTO::new);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }
}
