package br.com.sprint3.states.api.core;

import br.com.sprint3.states.domain.model.Regiao;
import org.springframework.core.convert.converter.Converter;

public class StringEnumConverte implements Converter<String, Regiao> {

    @Override
    public Regiao convert(String source) {
        try {
            return Regiao.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
