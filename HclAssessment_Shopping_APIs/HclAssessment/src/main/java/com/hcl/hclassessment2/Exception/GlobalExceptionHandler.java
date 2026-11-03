package com.hcl.hclassessment2.Exception;

import org.springframework.web.bind.annotation.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.server.ResponseStatusException; import org.springframework.http.*; import org.springframework.dao.DataIntegrityViolationException; import java.util.*;

@RestControllerAdvice public class GlobalExceptionHandler {
@ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<?> validation(MethodArgumentNotValidException ex){Map<String,String> errors=new LinkedHashMap<>();ex.getBindingResult().getFieldErrors().forEach(e->errors.put(e.getField(),e.getDefaultMessage()));return ResponseEntity.badRequest().body(Map.of("status",400,"errors",errors));}
@ExceptionHandler(ResponseStatusException.class) public ResponseEntity<?> status(ResponseStatusException ex){return ResponseEntity.status(ex.getStatusCode()).body(Map.of("status",ex.getStatusCode().value(),"message",ex.getReason()==null?"Request failed":ex.getReason()));}
@ExceptionHandler(DataIntegrityViolationException.class) public ResponseEntity<?> conflict(DataIntegrityViolationException ex){return ResponseEntity.status(409).body(Map.of("status",409,"message","Database constraint violation"));}
}
