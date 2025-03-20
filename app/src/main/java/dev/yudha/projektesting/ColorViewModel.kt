package dev.yudha.projektesting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ColorViewModel: ViewModel() {

    private val _colors = MutableLiveData<List<Color>>()

    var colorDatabase: ColorDatabase? = null

    val colors :LiveData<List<Color>>
        get() = _colors

    fun getColors (){
        viewModelScope.launch(Dispatchers.IO) {
            val arrayOfColor = colorDatabase?.ColorDao()?.getAll()
            _colors.postValue(arrayOfColor?.toList())
        }
    }

    fun getNumber(): Deferred<Int> {
        return viewModelScope.async {
//            delay
            10
        }
    }

    fun insertColor(color: Color){
        viewModelScope.launch(Dispatchers.IO){
            val arrayOfColor = colorDatabase?.ColorDao()?.insert(color)
            getColors()
        }
    }
}