package bs.spring.bootstrapt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/***
 * tutorial source : https://www.baeldung.com/spring-boot-start
 */

@EnableJpaRepositories("bs.spring.bootstrapt")
@EntityScan("bs.spring.bootstrapt")
@SpringBootApplication
class BootstraptApplication

fun main(args: Array<String>) {
  runApplication<BootstraptApplication>(*args)
}
