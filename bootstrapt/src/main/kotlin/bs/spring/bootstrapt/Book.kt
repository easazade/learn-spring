package bs.spring.bootstrapt

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "books")
class Book(
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long?,
  @Column(nullable = false, unique = true)
  var title: String,
  @Column(nullable = false)
  var author: String,
)