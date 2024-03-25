package com.fadlurahmanf.starterappcompose.core.exception

open class BaseException(
    open val enumMessage: String? = null,
    open val disabledBackButton: Boolean = false,
    override var message: String? = null,
) : Throwable(message = message) {

    companion object {
        const val PREFIX_GENERAL_EXCEPTION = "BASE_EXCEPTION"

        fun default(): BaseException {
            return BaseException(
                enumMessage = PREFIX_GENERAL_EXCEPTION,
                disabledBackButton = false,
            )
        }
    }

    fun toProperMessage(): String? {
        when (enumMessage) {
            "${PREFIX_GENERAL_EXCEPTION}_DATA_MISSING" -> {
                message = ""
                return message
            }
        }

        return ""
    }
}