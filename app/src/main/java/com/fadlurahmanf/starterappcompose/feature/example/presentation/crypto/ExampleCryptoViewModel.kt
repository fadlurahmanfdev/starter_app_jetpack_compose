package com.fadlurahmanf.starterappcompose.feature.example.presentation.crypto

import androidx.lifecycle.ViewModel
import com.fadlurahmanf.starterappcompose.feature.crypto.data.model.CryptoKey
import com.fadlurahmanf.starterappcompose.feature.crypto.data.repositories.CryptoRSARepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ExampleCryptoViewModel @Inject constructor(
    private val cryptoRSARepository: CryptoRSARepository
) : ViewModel() {
    private val _cryptoKeyState: MutableStateFlow<CryptoKey?> = MutableStateFlow(null)
    val cryptoKeyState: StateFlow<CryptoKey?> = _cryptoKeyState.asStateFlow()

    fun generateRSACryptoKey() {
        val key = cryptoRSARepository.generateKey()
        _cryptoKeyState.value = key
    }
}