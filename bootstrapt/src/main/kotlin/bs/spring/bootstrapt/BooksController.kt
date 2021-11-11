package bs.spring.bootstrapt

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/books")
class BookController {
  @Autowired
  private lateinit var bookRepository: BookRepository

  @GetMapping
  fun findAll() = bookRepository.findAll()

  @GetMapping("/title/{bookTitle}")
  fun findByTitle(@PathVariable bookTitle: String) = bookRepository.findBookByTitle(bookTitle)

  @GetMapping("/{id}")
  fun findOne(@PathVariable id: Long): Book {
    return bookRepository.findById(id)
      .orElseThrow { BookNotFoundException() }
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  fun create(@RequestBody book: Book) = bookRepository.save(book)

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Long) {
    bookRepository.findById(id)
      .orElseThrow { BookNotFoundException() }
    bookRepository.deleteById(id)
  }

  @PutMapping("/{id}")
  fun updateBook(@RequestBody book: Book, @PathVariable id: Long): Book {

    if (book.id != id) {
      throw RuntimeException("book mismatch exception")
    }
    bookRepository.findById(id)
      .orElseThrow { BookNotFoundException() }
    return bookRepository.save(book)
  }
}