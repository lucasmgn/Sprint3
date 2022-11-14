package br.com.sprint3.states.api.exceptionhandler;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManipuladorDeExcecao {

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<String> handleConflict() {
        return new ResponseEntity<>(String.format("Parâmetro inválido!"),HttpStatus.BAD_REQUEST);
    }

}
