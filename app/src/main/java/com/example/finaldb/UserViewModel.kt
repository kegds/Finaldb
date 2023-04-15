package com.example.finaldb

import android.util.Log
import androidx.lifecycle.*
import com.example.finaldb.entities.UserInfo
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    init {
        Log.d("UserViewModel", "New UserViewModel instance created")
    }


    val allUser: LiveData<List<UserInfo>>
        get() = repository.allUser.asLiveData()

    fun insert(userInfo: UserInfo) = viewModelScope.launch {
        repository.insert(userInfo)
    }

}

class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }
}