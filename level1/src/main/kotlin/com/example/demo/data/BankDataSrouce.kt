package com.example.demo.data

import com.example.demo.Bank

interface BankDataSrouce {
  fun getBanks(): Collection<Bank>
}