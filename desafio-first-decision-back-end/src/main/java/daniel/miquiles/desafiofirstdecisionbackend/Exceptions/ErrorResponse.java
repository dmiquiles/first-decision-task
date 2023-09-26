package daniel.miquiles.desafiofirstdecisionbackend.Exceptions;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final String message;
    private final int code;
    private final List<ErrorObject> errors;
    
}
