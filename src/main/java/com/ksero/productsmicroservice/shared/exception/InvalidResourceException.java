package com.ksero.productsmicroservice.shared.exception;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.ConstraintViolation;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidResourceException extends RuntimeException {
  public InvalidResourceException() {
    super();
  }

  public InvalidResourceException(String message) {
    super(message);
  }

  public InvalidResourceException(String entity, String message) {
    super(String.format("Entity called %s has this problem: %s", entity, message));
  }

  public <T> InvalidResourceException(String resourceName, Set<ConstraintViolation<T>> violations) {
    super(String.format("Not all constraints satisfied for %s: %s", resourceName,
        violations.stream().map(violation -> String.format("", violation.getPropertyPath(), violation.getMessage()))
            .collect(Collectors.joining(", "))));
  }
}
