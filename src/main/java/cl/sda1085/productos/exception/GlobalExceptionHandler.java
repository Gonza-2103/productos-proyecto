package cl.sda1085.productos.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex){
        Map<String,String> errores = new LinkedHashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((error) ->
            errores.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex){
        Map<String,String> error = new LinkedHashMap<>();
        error.put("error", "Error de Negocio");
        error.put("mensaje", ex.getMessage());

        //Si el mensaje YA EXISTE, hay que devolver 409 Conflict
        if (ex.getMessage().contains("ya existe")){
            return ResponseEntity.status(409).body(error);
        }
        return ResponseEntity.badRequest().body(error);
    }
}
