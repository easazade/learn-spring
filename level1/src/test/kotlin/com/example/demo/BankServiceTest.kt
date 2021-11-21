package com.example.demo

import com.example.demo.data.datasource.BankDataSource
import com.example.demo.data.datasource.MockBankDataSource
import com.example.demo.data.models.Bank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import io.mockk.*

internal class BankServiceTest {

  private val fakeBanks = listOf(Bank("01",1.0,1))
  private val datasource:BankDataSource = mockk(relaxed = true)
  private val service = BankService(datasource)

  @Test
  fun `should call its datasource to retrieve banks`(){
    // with
    every { datasource.getBanks() } returns fakeBanks
    // when
    val banks = service.getBanks()

    //then
    verify(exactly = 1) { datasource.getBanks() }
    assertThat(banks).isEqualTo(fakeBanks)

  }

}