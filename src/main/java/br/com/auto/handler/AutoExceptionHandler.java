package br.com.auto.handler;

import br.com.auto.domain.erros.ErroResponse;
import br.com.auto.domain.erros.ErroValidacaoResponse;
import br.com.auto.exception.InternalServerErrorException;
import br.com.auto.exception.NotFoundException;
import br.com.auto.exception.UnprocessableEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class AutoExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErroResponse> trataNotFoundException(NotFoundException notFoundException) {
        log.error(notFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getErroResponse(notFoundException.getMessage()));
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErroResponse> trataInternalServerErrorException(InternalServerErrorException internalServerErrorException) {
        log.error(internalServerErrorException.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getErroResponse(internalServerErrorException.getMessage()));
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<ErroResponse> trataUnprocessableEntityException(UnprocessableEntityException unprocessableEntityException) {
        log.error(unprocessableEntityException.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(getErroResponse(unprocessableEntityException.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoResponse>> trataMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        var fieldErrors = methodArgumentNotValidException.getFieldErrors();

        var erros = fieldErrors.stream()
                .map(fieldError -> new ErroValidacaoResponse(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.unprocessableEntity().body(erros);
    }

    private ErroResponse getErroResponse(final String mensagem) {
        ErroResponse erroResponse = new ErroResponse();
        erroResponse.setMensagem(mensagem);

        return erroResponse;
    }
}
