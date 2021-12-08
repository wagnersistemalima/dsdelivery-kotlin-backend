package com.sistemalima.dsdelivery.products.response

import com.sistemalima.dsdelivery.products.model.Product

data class InsertProductResponse(
    val id: Long?
){
    constructor(product: Product): this(product.id)
}
