package br.com.sprint3.states.api.exceptionhandler;

import br.com.sprint3.states.domain.exception.ErroDeFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacao {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormulario> handle(MethodArgumentNotValidException exception) {

        List<ErroDeFormulario> erroDeFormualarios = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors(); //pegando todos os erros

        fieldErrors.forEach(e -> {
            //pegando a mensagem de erro no idioma correto
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroDeFormulario erro = new ErroDeFormulario(e.getField(), mensagem);
            erroDeFormualarios.add(erro);
        });
        return erroDeFormualarios;
    }
}
