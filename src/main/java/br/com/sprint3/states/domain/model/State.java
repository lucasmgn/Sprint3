package br.com.sprint3.states.domain.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;

@Entity(name = "States")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    @Length(min = 4)
    private String nome;
    @Enumerated(EnumType.STRING)
    private Regiao regiao;
    @Column(nullable = false)
    @PositiveOrZero
    private Long populacao;
    @Column(nullable = false)
    private String capital;
    @Column(nullable = false)
    @PositiveOrZero
    private Long area;

    public State() {
    }

    public State(String nome, Regiao regiao, Long populacao, String capital, Long area) {
        this.nome = nome;
        this.regiao = regiao;
        this.populacao = populacao;
        this.capital = capital;
        this.area = area;
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State states = (State) o;
        return Objects.equals(id, states.id) && Objects.equals(nome, states.nome) && Objects.equals(regiao, states.regiao) && Objects.equals(populacao, states.populacao) && Objects.equals(capital, states.capital) && Objects.equals(area, states.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, regiao, populacao, capital, area);
    }
}
