package com.example.demo.data.datasource

import com.example.demo.data.models.Bank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

// the value in @Repository `network` is called a qualifier. we can path a Qualifier to any SpringBoot component whether they are
// @Repository, @Component, @Service,  @Bean etc
@Repository("network")
class NetworkDataSource(
  @Autowired private val restTemplate: RestTemplate
) : BankDataSource {
  override fun getBanks(): Collection<Bank> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getBank(accountNumber: String): Bank {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun addBank(bank: Bank): Bank {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun updateBank(accountNumber: String, bank: Bank): Bank {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteBank(accountNumber: String) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}