package com.example.workhub.exception;

/**
 * Simple runtime exception to indicate a requested resource was not found.
 */
public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
