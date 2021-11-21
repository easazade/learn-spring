package com.example.demo

import com.example.demo.data.MockBankDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest {

  private val datasource = MockBankDataSource()

  @Test
  fun `should provide a collection of banks`() {
    // when
    val banks = datasource.getBanks()
    // then
    assertThat(banks).isNotEmpty
  }

  @Test
  fun `all banks should provide some data`() {
    // when
    val banks = datasource.getBanks()
    // then
    assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
  }

}