package com.rakaagisaputra.infinitetugasapp.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakaagisaputra.infinitetugasapp.data.Category
import com.rakaagisaputra.infinitetugasapp.network.menuService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    private val _categoriesState = mutableStateOf(MenuState())
    val categoryState: State<MenuState> = _categoriesState

    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try{
                val response = menuService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            }catch (e: Exception){
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    data class MenuState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )

}