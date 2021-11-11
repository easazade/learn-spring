package bs.spring.bootstrapt

import org.hibernate.exception.ConstraintViolationException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

class RestExceptionHandler : ResponseEntityExceptionHandler() {
  @ExceptionHandler(BookNotFoundException::class)
  fun handleNotFound(
    ex: Exception, request: WebRequest
  ): ResponseEntity<Any> {
    return handleExceptionInternal(
      ex, "Book not found", HttpHeaders(), HttpStatus.NOT_FOUND, request
    )
  }

  @ExceptionHandler(
//    BookIdMismatchException::class,
    ConstraintViolationException::class,
    DataIntegrityViolationException::class
  )
  fun handleBadRequest(
    ex: Exception, request: WebRequest
  ): ResponseEntity<Any> {
    return handleExceptionInternal(
      ex, ex.localizedMessage,
      HttpHeaders(), HttpStatus.BAD_REQUEST, request
    )
  }
}