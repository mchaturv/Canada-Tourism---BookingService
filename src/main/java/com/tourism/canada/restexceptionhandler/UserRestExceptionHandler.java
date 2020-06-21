package com.tourism.canada.restexceptionhandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tourism.canada.exception.ErrorResponse;
import com.tourism.canada.exception.JwtRelatedException;
import com.tourism.canada.exception.UserRelatedException;

/**
 * @author Mayank
 *
 */
@ControllerAdvice
public class UserRestExceptionHandler {

	/**
	 * 
	 */

	@ExceptionHandler(value = UserRelatedException.class)
	public ResponseEntity<ErrorResponse> handleException(UserRelatedException exe) {
		ResponseEntity<ErrorResponse> responseEntity = null;
		String message = new String();
		if (exe.getMessage().contains("not found")) {
			message = exe.getMessage();
			ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), message, System.currentTimeMillis());
			responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		} else if (exe.getMessage().contains("already in use")) {
			message = exe.getMessage();
			ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message,
					System.currentTimeMillis());
			responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		} else if (exe.getMessage().contains("Duplicate")) {
			String errorString[] = message.split("'");
			message = "Entity with provided name: " + errorString[1] + " already exists";

			System.out.println(message);

			ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message,
					System.currentTimeMillis());
			responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

		} else {
			message = exe.getMessage();
			ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message,
					System.currentTimeMillis());
			responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exe) {
		String message = new String();
		for (ConstraintViolation<?> violation : exe.getConstraintViolations()) {
			message = violation.getRootBeanClass().getSimpleName() + " " + violation.getPropertyPath() + ": "
					+ violation.getMessage();
		}

		message = exe.getMessage();
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message, System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = JwtRelatedException.class)
	public ResponseEntity<ErrorResponse> handleJWTException(JwtRelatedException exe) {
		ResponseEntity<ErrorResponse> responseEntity = null;
		String message = new String();
		message = exe.getMessage();
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message, System.currentTimeMillis());
		responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleConditionalValidationException(MethodArgumentNotValidException exe) {
		ResponseEntity<ErrorResponse> responseEntity = null;
		String message = new String();
		Errors errors = exe.getBindingResult();
		List<FieldError> ferror = errors.getFieldErrors();
		for (FieldError err : ferror) {
			message = err.getDefaultMessage();
		}
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message, System.currentTimeMillis());
		responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	@ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleConditionalValidationException(
			SQLIntegrityConstraintViolationException exe) {
		ResponseEntity<ErrorResponse> responseEntity = null;

		String message = exe.getMessage();
		System.out.println(message);
		if (message.contains("Duplicate")) {
			String errorString[] = message.split("'");
			message = "Entity with provided name: " + errorString[1] + " already exists";
		}

		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message, System.currentTimeMillis());
		responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	@ExceptionHandler(value = AuthenticationCredentialsNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleJWTException(AuthenticationCredentialsNotFoundException exe) {
		ResponseEntity<ErrorResponse> responseEntity = null;
		String message = new String();
		message = "User is not Authenticated. Please Provide Authentication token.";
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message, System.currentTimeMillis());
		responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	@ExceptionHandler(value = AccessDeniedException.class)
	public ResponseEntity<ErrorResponse> handleJWTException(AccessDeniedException exe) {
		ResponseEntity<ErrorResponse> responseEntity = null;
		String message = new String();
		message = "User is not Authorized. Access Denied.";
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message, System.currentTimeMillis());
		responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<ErrorResponse> handleJWTException(ValidationException exe) {
		ResponseEntity<ErrorResponse> responseEntity = null;
		String message = new String();
		message = exe.getLocalizedMessage();
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message, System.currentTimeMillis());
		responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

}
