package com.bchmsl.notes.common.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun Fragment.async(context:CoroutineContext = EmptyCoroutineContext, block: suspend (CoroutineScope) -> Unit){
    viewLifecycleOwner.lifecycleScope.launch(context){
        block.invoke(this)
    }
}

fun ViewModel.async(context: CoroutineContext = EmptyCoroutineContext, block: suspend (CoroutineScope) -> Unit){
    viewModelScope.launch(context) {
        block.invoke(this)
    }
}