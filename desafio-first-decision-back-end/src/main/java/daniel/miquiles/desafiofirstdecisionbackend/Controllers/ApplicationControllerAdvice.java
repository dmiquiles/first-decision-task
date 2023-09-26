package daniel.miquiles.desafiofirstdecisionbackend.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import daniel.miquiles.desafiofirstdecisionbackend.Exceptions.ErrorObject;
import daniel.miquiles.desafiofirstdecisionbackend.Exceptions.ErrorResponse;
import daniel.miquiles.desafiofirstdecisionbackend.Exceptions.SenhasNaoCoincidem;
import jakarta.websocket.MessageHandler.Partial;

@RestControllerAdvice
public class ApplicationControllerAdvice {


    @ExceptionHandler(SenhasNaoCoincidem.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleSenhasNaoCoincidemException(SenhasNaoCoincidem ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {


        // return getErrors(ex);
        List<ErrorObject> errors = getErrors(ex);

        return new ErrorResponse("Requisição possui campos inválidos", ex.getStatusCode().value(), errors);
    }


    // private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ErrorObject> errors) {
    //     return new ErrorResponse("Requisição possui campos inválidos", status.value(),
    //             status.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);
    // }

    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }
    
}
