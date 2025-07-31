package cz.mokripat.transparents.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import android.util.Log
import cz.mokripat.transparents.domain.repository.AccountsRepository

class AccountsViewModel(
    private val repository: AccountsRepository
) : ViewModel() {

    fun fetchAccounts() {
        viewModelScope.launch {
            try {
                val response = repository.fetchAccounts()
                Log.d("AccountsViewModel", "Accounts: $response")
            } catch (e: Exception) {
                Log.e("AccountsViewModel", "Error fetching accounts", e)
            }
        }
    }
}
