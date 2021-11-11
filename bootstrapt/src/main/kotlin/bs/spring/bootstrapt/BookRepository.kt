package bs.spring.bootstrapt

import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long> {
  fun findBookByTitle(title: String): List<Book>
}