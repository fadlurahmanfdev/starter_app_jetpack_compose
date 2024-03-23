package com.fadlurahmanf.starterappcompose.feature.crypto.data.repositories

import com.fadlurahmanf.starterappcompose.feature.crypto.data.enums.PaddingScheme

interface CryptoAESRepository {
    fun generateKey(): String
    fun encryptECB(
        plainText: String, secretKey: String, padding: PaddingScheme = PaddingScheme.PKCS7
    ): String?

    fun decryptECB(
        encryptedText: String, secretKey: String, padding: PaddingScheme = PaddingScheme.PKCS7
    ): String?

    fun encryptCBC(
        plainText: String, secretKey: String, padding: PaddingScheme = PaddingScheme.PKCS7
    ): String?

    fun decryptCBC(
        encryptedText: String, secretKey: String, padding: PaddingScheme = PaddingScheme.PKCS7
    ): String?
}