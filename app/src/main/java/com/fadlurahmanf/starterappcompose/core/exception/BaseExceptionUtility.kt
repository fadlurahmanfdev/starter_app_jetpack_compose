package com.fadlurahmanf.starterappcompose.core.exception

class BaseExceptionUtility {
    companion object {
        fun toBaseApiExceptionGeneral(enumMessage: String): BaseApiException {
            return BaseApiException(
                code = 400,
                disabledBackButton = false,
                enumMessage = "${BaseException.PREFIX_GENERAL_EXCEPTION}_${enumMessage}"
            )
        }
    }
}