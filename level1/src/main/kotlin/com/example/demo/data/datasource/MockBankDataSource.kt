package com.example.demo.data.datasource

import com.example.demo.data.models.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

  private val banks = mutableListOf(
    Bank("7856", 3.14, 1),
    Bank("1010", 17.0, 1),
    Bank("1234", 1.0, 1),
  )

  override fun getBanks(): Collection<Bank> = banks

  override fun getBank(accountNumber: String): Bank {
    return banks.firstOrNull { it.accountNumber == accountNumber }
      ?: throw NoSuchElementException("Could not find the bank object with account number $accountNumber")
  }

  override fun addBank(bank: Bank): Bank {
    if (banks.any { it.accountNumber == bank.accountNumber }) {
      throw IllegalArgumentException("Bank with Account number ${bank.accountNumber} already exists")
    }
    banks.add(bank)
    return bank
  }

  override fun updateBank(accountNumber: String, bank: Bank): Bank {
    val oldObject = banks.firstOrNull { it.accountNumber == accountNumber }
      ?: throw NoSuchElementException("Could not find the bank object with account number $accountNumber")

    banks.remove(oldObject)
    banks.add(bank)
    return bank
  }

  override fun deleteBank(accountNumber: String) {
    val oldObject = banks.firstOrNull { it.accountNumber == accountNumber }
      ?: throw NoSuchElementException("Could not find the bank object with account number $accountNumber")

    banks.remove(oldObject)
  }

}