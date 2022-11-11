package br.com.sprint3.states.api.model.form;

import br.com.sprint3.states.domain.model.Regiao;
import br.com.sprint3.states.domain.model.State;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StateAtualizacaoForm {

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

    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public State atualizar(State state) {
        state.setNome(this.nome);
        state.setRegiao(this.regiao);
        state.setPopulacao(this.populacao);
        state.setCapital(this.capital);
        state.setArea(this.area);

        return state;
    }
}
