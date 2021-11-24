package com.example.demo.data.datasource

import com.example.demo.data.models.Bank

interface BankDataSource {

  fun getBanks(): Collection<Bank>

  fun getBank(accountNumber: String):Bank

}