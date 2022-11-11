package br.com.sprint3.states.api.model.form;

import br.com.sprint3.states.domain.model.Regiao;
import br.com.sprint3.states.domain.model.State;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StateForm {

    @NotBlank
    private String nome;
    @NotNull
    private Regiao regiao;
    @NotNull
    private Long populacao;
    @NotBlank
    private String capital;
    @NotNull
    private Long area;

    public State converterForm() {
        return new State(nome, regiao, populacao, capital, area);
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
