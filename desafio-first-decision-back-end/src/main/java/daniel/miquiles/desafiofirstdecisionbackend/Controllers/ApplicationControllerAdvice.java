package daniel.miquiles.desafiofirstdecisionbackend.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import daniel.miquiles.desafiofirstdecisionbackend.Exceptions.SenhasNaoCoincidem;

@RestControllerAdvice
public class ApplicationControllerAdvice {


    @ExceptionHandler(SenhasNaoCoincidem.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNotFoundException(SenhasNaoCoincidem ex) {
        return ex.getMessage();
    }
    
}
