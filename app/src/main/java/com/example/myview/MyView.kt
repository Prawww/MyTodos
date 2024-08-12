package com.example.myview

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myview.Network.RetrofitClient
import com.example.myview.Network.Todo
import kotlinx.coroutines.launch

class MyView : ViewModel() {
    private var _todos: MutableLiveData<List<Todo>> = MutableLiveData<List<Todo>>()
    val todos : LiveData<List<Todo>> get() = _todos
    init{
      display()
    }

    fun display(){
        viewModelScope.launch{
            val response = RetrofitClient.instance.getTodos()
            _todos.postValue(response)

        }
    }
}