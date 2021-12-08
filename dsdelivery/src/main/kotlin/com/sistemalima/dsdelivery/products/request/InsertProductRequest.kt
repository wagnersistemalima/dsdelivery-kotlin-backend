package com.sistemalima.dsdelivery.products.request

import com.sistemalima.dsdelivery.products.model.Product
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

data class InsertProductRequest(

    @field:NotBlank
    val name: String,

    @field:Positive
    val price: Double,

    @field:NotBlank
    val description: String,

    @field:NotBlank
    val imageUri: String
) {
    // metodo para transformar request em model
    fun toModel(): Product {
        return Product(
            name = name,
            price = price,
            description = description,
            imageUri = imageUri
        )
    }
}
