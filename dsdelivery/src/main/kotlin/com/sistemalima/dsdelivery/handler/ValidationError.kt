package com.sistemalima.dsdelivery.handler

import java.time.Instant

data class ValidationError(
    val timestamp: Instant,
    val status: Int,
    val error: String,
    val message: String,
    val path: String
){
    val errors = mutableListOf<FieldMessage>()

    // metodo para adicionar erro na lista de erros
    fun addError(fieldName: String, message: String) {

        errors.add(FieldMessage(fieldName, message))

    }
}
